package service;

import org.example.entity.User;

import java.sql.SQLException;

public interface UserService {
    void save(User user) throws SQLException;
    User load(int userId) throws SQLException;
    void delete(int userId) throws SQLException;

}
