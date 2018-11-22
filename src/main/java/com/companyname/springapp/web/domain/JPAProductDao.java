package com.companyname.springapp.web.domain;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository(value = "productDao")
public class JPAProductDao implements ProductDao {

    private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Product> getProductList() {
        return em.createQuery("select p from Product p order by p.id").getResultList();
    }

    @Transactional(readOnly = false)
    public void saveProduct(Product prod) {
        em.merge(prod);
    }

    @Transactional(readOnly = false)
    public Product addProduct(Product prod) {
        //em.getTransaction().begin();
        em.persist(prod);
        //em.getTransaction().commit();
        return prod;
    }

    @Transactional(readOnly = true)
    public Product getProduct(Integer id) {
        Product p=em.find(Product.class,id);
        return p;
    }

    @Override
    public Product deleteProduct(Integer id) {
        Product p=em.find(Product.class,id);
        em.remove(p);
        return  p;

    }


}
