/*
package lv.shebaka.smartcookbook.data;

import lv.shebaka.smartcookbook.domain.Recipe;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeRealDatabase extends JDBCDatabase implements RecipeDatabase{

    @Override
    public void add(Recipe recipe) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "insert into recipes(id, title, description) values(default, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, recipe.getTitle());
            preparedStatement.setString(2, recipe.getDesc());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                recipe.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            System.out.println("Exception while execute RecipeDAOImpl.save");
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            closeConnection(connection);
        }


    }

    @Override
    public Optional<Recipe> findByTitle(String title) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from recipes where title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            ResultSet resultSet = preparedStatement.executeQuery();
            Recipe recipe = null;
            if (resultSet.next()){
                recipe = new Recipe();
                recipe.setId(resultSet.getLong("id"));
                recipe.setTitle(resultSet.getString("title"));
                recipe.setDesc(resultSet.getString("description"));
            }
            return Optional.ofNullable(recipe);
        } catch (SQLException e) {
            System.out.println("Exception while execute RecipeDAOImpl.getByTitle()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void remove(Recipe recipe) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "delete from recipes where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,recipe.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception while execute RecipeDAOImpl.delete()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from recipes";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Recipe recipe = new Recipe();
                recipe.setId(resultSet.getLong("id"));
                recipe.setTitle(resultSet.getString("title"));
                recipe.setDesc(resultSet.getString("description"));
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            System.out.println("Exception while getting recipe list RecipesDAOImpl.getAll()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
        return recipes;

    }

}
*/
