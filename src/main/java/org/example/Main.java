package org.example;

import org.example.entity.Category;
import org.example.entity.User;
import repository.CategoryRepository;
import repository.UserRepository;
import repository.impl.CategoryRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CategoryRepository categoryRepository = new CategoryRepositoryImpl();
        Category category = new Category("nice","very nice");
        System.out.println(categoryRepository.existsByName("nice"));
    }
}