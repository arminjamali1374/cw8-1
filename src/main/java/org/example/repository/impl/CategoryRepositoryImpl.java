package org.example.repository.impl;

import org.example.entity.Category;
import org.example.util.ApplicationContext;
import org.example.repository.CategoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public void save(Category category) throws SQLException {
        String query = """
                INSERT INTO "category" (name, description) values (?,?)
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setString(1,category.getName());
        preparedStatement.setString(2,category.getDescription());
        preparedStatement.execute();
    }

    @Override
    public Category load(int categoryId) throws SQLException {
        String query = """
                SELECT * FROM "category" WHERE id = ?
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,categoryId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return new Category(categoryId,resultSet.getString(2),resultSet.getString(3));
    }

    @Override
    public void delete(int categoryId) throws SQLException {
        String query = """
                DELETE FROM category WHERE id = ?
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,categoryId);
        preparedStatement.execute();
    }

    @Override
    public boolean existsByName(String categoryName) throws SQLException {
        String query = """
                SELECT exists(SELECT * FROm category WHERE name = ?)
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setString(1,categoryName);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getBoolean(1);
    }
}
