package com.companyname.springapp.web.service;

import java.util.List;

import com.companyname.springapp.web.domain.Product;
import com.companyname.springapp.web.domain.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        return productDao.getProductList();
    }

    @Override
    public Product addProduct(Product p) {
        productDao.addProduct(p);
        return p;
    }

    @Override
    public Product updateProduct(Product p) {
        productDao.saveProduct(p);
        return p;
    }

    @Override
    public Product getProduct(Integer id) {
        return productDao.getProduct(id);
    }

    @Override
    public Product deleteProduct(Integer id) {
        return productDao.deleteProduct(id);
    }

    public void increasePrice(int percentage) {
        List<Product> products = productDao.getProductList();
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() *
                        (100 + percentage)/100;
                product.setPrice(newPrice);
                productDao.saveProduct(product);
            }
        }
    }
}