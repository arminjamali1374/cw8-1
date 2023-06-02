package service.Impl;

import org.example.entity.Category;
import org.example.repository.CategoryRepository;
import org.example.repository.impl.CategoryRepositoryImpl;
import service.CategoryService;

import java.sql.SQLException;

public class CategoryServiceImpl implements CategoryService {
    static CategoryRepository categoryRepository=new CategoryRepositoryImpl();
    @Override
    public void save(Category category) throws SQLException {
        if (categoryRepository.existsByName(category.getName())){
            System.out.println("Category name already exists");
            return;
        }
        categoryRepository.save(category);
    }

    @Override
    public Category load(int categoryId) throws SQLException {
       return categoryRepository.load(categoryId);
    }

    @Override
    public void delete(int categoryId) throws SQLException {
        categoryRepository.delete(categoryId);

    }
}
