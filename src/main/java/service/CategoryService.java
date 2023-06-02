package service;

import org.example.entity.Category;

import java.sql.SQLException;

public interface CategoryService {
    void save(Category category) throws SQLException;
    Category load(int categoryId) throws SQLException;
    void  delete(int categoryId) throws SQLException;
}
