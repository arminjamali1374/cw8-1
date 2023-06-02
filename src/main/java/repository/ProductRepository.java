package repository;

import org.example.entity.Brand;
import org.example.entity.Product;

import java.sql.SQLException;

public interface ProductRepository {
    void save (Product product) throws SQLException;
    Product load (int productId) throws SQLException;
    void delete (int productId) throws SQLException;
    boolean existsByName (String productName) throws SQLException;
}
