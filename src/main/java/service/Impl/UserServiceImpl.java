package service.Impl;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.repository.impl.UserRepositoryImpl;
import service.UserService;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {
    static UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void save(User user) throws SQLException {
        if (userRepository.existsByUsername(user.getUsername()) && userRepository.existsByEmail(user.getEmail())) {
            System.out.println("user or email already exists");
            return;
        }
        if (!isValidEmail(user.getEmail())){
            System.out.println("not valid email");
            return;
        }
        if (!isValidPassword(user.getPassword())){
            System.out.println("not valid password");
            return;
        }
        userRepository.save(user);
    }


    @Override
    public User load(int userId) throws SQLException {
      return userRepository.load(userId);
    }

    @Override
    public void delete(int userId) throws SQLException {
        userRepository.delete(userId);
    }

    private boolean isValidEmail(String email){
        return email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$");
    }

    private boolean isValidPassword(String password){
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
    }
}
