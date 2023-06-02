package org.example.entity;

public class Product {
    private  int id ;
    private  String name ;
    private String createData ;

    private  int categoryId ;
    private  int brandId ;

    public Product(int id, String name, String createData, int categoryId, int brandId) {
        this.id = id;
        this.name = name;
        this.createData = createData;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateData() {
        return createData;
    }

    public void setCreateData(String createData) {
        this.createData = createData;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}
