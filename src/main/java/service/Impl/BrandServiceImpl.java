package service.Impl;

import org.example.entity.Brand;
import org.example.repository.BrandRepository;
import org.example.repository.impl.BrandRepositoryImpl;
import service.BrandService;

import java.sql.SQLException;

public class BrandServiceImpl implements BrandService {

    @Override
    public void save(Brand brand) throws SQLException {
        if (brandRepository.existsByName(brand.getName())){
            System.out.println("name already exists");
            return;
        }
        if (!isValidWebsite(brand.getWebsite())){
            System.out.println("valid website");
            return;
        }
        brandRepository.save(brand);
    }

    @Override
    public Brand load(int brandId) throws SQLException {
        return brandRepository.load(brandId);
    }

    @Override
    public void delete(int brandId) throws SQLException {
        brandRepository.delete(brandId);
    }

    private boolean isValidWebsite(String website){
        return website.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");

    }
}
