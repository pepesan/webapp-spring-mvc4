package com.companyname.springapp.web.domain;

import java.util.List;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

    public Product addProduct(Product prod);

    public Product getProduct(Integer id);

    public Product deleteProduct(Integer id);

}
