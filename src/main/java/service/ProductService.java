package service;

import org.example.entity.Product;

import java.sql.SQLException;

public interface ProductService {
    void save(Product product) throws SQLException;
    Product load(int productId) throws SQLException;
    void delete(int productId) throws SQLException;
}
