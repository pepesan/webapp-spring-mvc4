package com.companyname.springapp.web.domain;

import java.util.List;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}
