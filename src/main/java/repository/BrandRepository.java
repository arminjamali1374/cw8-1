package repository;

import org.example.entity.Brand;

import java.sql.SQLException;

public interface BrandRepository {
    void save (Brand brand) throws SQLException;
    Brand load (int brandId) throws SQLException;
    void delete (int brandId) throws SQLException;
    boolean existsByName (String brandName) throws SQLException;
}
