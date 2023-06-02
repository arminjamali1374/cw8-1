package service;

import org.example.entity.Brand;

import java.sql.SQLException;

public interface BrandService {
    void save(Brand brand) throws SQLException;
    Brand load(int brandId) throws SQLException;
    void delete(int brandId) throws SQLException;
}
