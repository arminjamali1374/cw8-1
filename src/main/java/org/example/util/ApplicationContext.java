package org.example.util;

import org.example.repository.BrandRepository;
import org.example.repository.CategoryRepository;
import org.example.repository.ProductRepository;
import org.example.repository.UserRepository;
import org.example.repository.impl.BrandRepositoryImpl;
import org.example.repository.impl.CategoryRepositoryImpl;
import org.example.repository.impl.ProductRepositoryImpl;
import org.example.repository.impl.UserRepositoryImpl;

import java.sql.Connection;

public class ApplicationContext {
    private static Connection connection;
    private static BrandRepository brandRepository;
    private static CategoryRepository categoryRepository;
    private static ProductRepository productRepository;
    private static UserRepository userRepository;

    static {
        connection = ConnectionUtils.getConnection();
        brandRepository= new BrandRepositoryImpl(connection);
        productRepository=new ProductRepositoryImpl(connection);
        userRepository=new UserRepositoryImpl(connection);
        categoryRepository=new CategoryRepositoryImpl(connection);
    }

}
