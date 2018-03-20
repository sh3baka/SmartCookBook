package lv.shebaka.smartcookbook.data;

import lv.shebaka.smartcookbook.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class UserRealDatabase extends JDBCDatabase implements UserDatabase {

    @Override
    public void add(User user) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "insert into user(id, username, password, email, create_time) values(default, ?, ?, ?, default)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3, user.getEmail());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                user.setId(resultSet.getLong(1));
                user.setRegDate(resultSet.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Exception while execute userDAOimpl.save");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public Optional<User> findByUsername(String username) {
        return null;
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
