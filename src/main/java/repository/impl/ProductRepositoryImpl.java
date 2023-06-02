package repository.impl;

import org.example.entity.Product;
import repository.ProductRepository;

import java.sql.SQLException;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public void save(Product product) throws SQLException {

    }

    @Override
    public Product load(int productId) throws SQLException {
        return null;
    }

    @Override
    public void delete(int productId) throws SQLException {

    }

    @Override
    public boolean existsByName(String productName) throws SQLException {
        return false;
    }
}
