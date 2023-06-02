package repository;

import org.example.entity.User;

import java.sql.SQLException;

public interface UserRepository {
    void save (User user) throws SQLException;
    User load (int userId) throws SQLException;
    void delete (int userId) throws SQLException;
    boolean validUsername(User user) throws SQLException;
    boolean validEmail(User user) throws SQLException;
}
