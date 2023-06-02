package repository.impl;

import org.example.entity.User;
import org.example.util.ApplicationContext;
import repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void save(User user) throws SQLException {
        String query = """
    INSERT INTO "user" (name,username,email,password) values (?,?,?,?)
    """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getUsername());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4,user.getPassword());

        preparedStatement.execute();
    }

    @Override
    public User load(int userId) throws SQLException {
        String query = """ 
                SELECT * FROM "user" WHERE id = ?;
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,userId);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return new User(userId,resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));

    }

    @Override
    public void delete(int userId) throws SQLException {
        String query = """ 
                DELETE FROM "user" WHERE id = ?;
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,userId);
        preparedStatement.executeQuery();

    }

    @Override
    public boolean existsByUsername(User user) throws SQLException {
        String query = """
                SELECT count(*) FROM "user" WHERE username = ?
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setString(1,user.getUsername());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getInt(1) == 0;
    }

    @Override
    public boolean existsByEmail(User user) throws SQLException {
        String query = """
                SELECT count(*) FROM "user" WHERE email = ?
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setString(1,user.getEmail());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getInt(1) == 0;
    }
}
