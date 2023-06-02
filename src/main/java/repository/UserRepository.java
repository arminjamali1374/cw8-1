package repository;

import org.example.entity.User;

import java.sql.SQLException;

public interface UserRepository {
    void save (User user) throws SQLException;
    User load (int userId) throws SQLException;
    void delete (int userId) throws SQLException;
    boolean existsByUsername(User user) throws SQLException;
    boolean existsByEmail(User user) throws SQLException;
}
