package org.example.repository.impl;

import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.example.util.ApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpl implements ProductRepository {
    private final Connection connection;
    public ProductRepositoryImpl(Connection connection, Connection connection1) {

        this.connection = connection1;
    }

    @Override
    public void save(Product product) throws SQLException {
        String query= """
                insert into "product" (name,create_date,category_id,brand_id) values (?,?,?,?)
                """;
        PreparedStatement preparedStatement= ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setString(2,product.getCreateData());
        preparedStatement.setInt(3,product.getCategoryId());
        preparedStatement.setInt(4,product.getBrandId());
        preparedStatement.execute();

    }
    @Override
    public Product load(int productId) throws SQLException {
        String query= """
                select * FROM "product"  where id=?
                """;
        PreparedStatement preparedStatement=ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,productId);
        ResultSet resultSet= preparedStatement.executeQuery();
        resultSet.next();
        return new Product(productId,resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5));
    }

    @Override
    public void delete(int productId) throws SQLException {
        String query= """
                delete from "product" where id=?
                """;
        PreparedStatement preparedStatement=ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,productId);
        preparedStatement.execute();
    }

    @Override
    public boolean existsByName(String productName) throws SQLException {
        String query= """
                select exists(select * from "product" where name=?)
                """;
        PreparedStatement preparedStatement=ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setString(1,productName);
        ResultSet resultSet= preparedStatement.executeQuery();
        resultSet.next();
        return  resultSet.getBoolean(1);
    }
}
