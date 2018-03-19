package lv.shebaka.smartcookbook.data;

        import java.io.IOException;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import java.util.Properties;

public class JDBCDatabase {
    private static final String DB_CONFIG_FILE = "database.properties";

    protected String jdbcUrl = null;
    protected String driverClass = null;
    protected String userName = null;
    protected String password = null;

    public JDBCDatabase() {
        initDatabaseConnectProperties();
        regJDBCDriver();
    }

    private void regJDBCDriver() {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("Exception while registering JDBC driver!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void initDatabaseConnectProperties() {
        Properties properties = new Properties();

        try {
            properties.load(JDBCDatabase.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE));

            jdbcUrl = properties.getProperty("jdbc.url");
            driverClass = properties.getProperty("driverClass");
            userName = properties.getProperty("database.user.name");
            password = properties.getProperty("database.user.password");
        } catch (IOException e) {
            System.out.println("Exception while reading JDBC config from file = " + DB_CONFIG_FILE);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (SQLException e) {
            System.out.println("Exception while getting connection to DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception while closing connection to DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
