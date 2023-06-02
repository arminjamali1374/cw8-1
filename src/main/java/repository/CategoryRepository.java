package repository;

import org.example.entity.Brand;
import org.example.entity.Category;

import java.sql.SQLException;

public interface CategoryRepository {
    void save (Category category) throws SQLException;
    Brand load (int categoryId) throws SQLException;
    void delete (int categoryId) throws SQLException;
    boolean existsByName (String categoryName) throws SQLException;
}
