package repository;

import org.example.entity.User;

public interface UserRepository {
    void save (User user);
    User load (int userId);
    void delete (int userId);
    boolean validUsername(User user);
}
