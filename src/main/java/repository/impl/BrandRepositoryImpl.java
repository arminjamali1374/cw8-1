package repository.impl;

import org.example.entity.Brand;
import org.example.util.ApplicationContext;
import repository.BrandRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRepositoryImpl implements BrandRepository {
    @Override
    public void save(Brand brand) throws SQLException {
        String query = """
                INSERT INTO "brand" (name, website, description) values (?,?,?)
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setString(1, brand.getName());
        preparedStatement.setString(2,brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());

        preparedStatement.execute();
    }

    @Override
    public Brand load(int brandId) throws SQLException {
        String query = """
                SELECT * FROM brand WHERE id = ?
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,brandId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return new Brand(brandId,resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
    }

    @Override
    public void delete(int brandId) throws SQLException {
        String query = """
                DELETE FROM brand WHERE id = ?
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,brandId);
        preparedStatement.execute();
    }

    @Override
    public boolean existsByName(String brandName) throws SQLException {
        String query = """
                SELECT count(*) FROM brand WHERE name = ?
                """;
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setString(1,brandName);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return (resultSet.getInt(1) == 0);
    }
}
