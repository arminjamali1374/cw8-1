package org.example;

import org.example.entity.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User("Shahrad","Shahrad","shahrad@gmail.com","12345");
        System.out.println(userRepository.existsByUsername(user));
    }
}