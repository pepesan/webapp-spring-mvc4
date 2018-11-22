package com.companyname.springapp.web.service;

import com.companyname.springapp.web.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class HyperSimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    private List<Product> products;

    HyperSimpleProductManager(){
        this.products= new ArrayList<Product>();
        Product p=new Product();
        p.setDescription("Sofa de Ikea");
        p.setPrice(22.3);
        this.products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product addProduct(Product p) {
        products.add(p);
        return p;
    }

    @Override
    public Product updateProduct(Product p) {
        return null;
    }

    @Override
    public Product getProduct(Integer id) {
        return null;
    }

    @Override
    public Product deleteProduct(Integer id) {
        return null;
    }

    public void increasePrice(int percentage) {
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() *
                        (100 + percentage)/100;
                product.setPrice(newPrice);
            }
        }
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
