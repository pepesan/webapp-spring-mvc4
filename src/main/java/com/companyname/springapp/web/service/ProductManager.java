package com.companyname.springapp.web.service;

import java.io.Serializable;
import java.util.List;

import com.companyname.springapp.web.domain.Product;

public interface ProductManager extends Serializable {

    public void increasePrice(int percentage);

    public List<Product> getProducts();

    public Product addProduct(Product p);

    public Product updateProduct(Product p);

    public Product getProduct(Integer id);

    public Product deleteProduct(Integer id);

}
