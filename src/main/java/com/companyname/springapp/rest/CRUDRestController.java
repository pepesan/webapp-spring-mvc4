package com.companyname.springapp.rest;

import com.companyname.springapp.web.domain.Product;
import com.companyname.springapp.web.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CRUDRestController {

    @Autowired
    private ProductManager productManager;
    @RequestMapping(value = "/productos/",method = RequestMethod.GET)
    public List<Product> showDato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> listado=productManager.getProducts();
        return listado;
    }
    //@PostMapping("/dato/")
    @RequestMapping(value = "/productos/",method = RequestMethod.POST)
    public Product addDato(@RequestBody Product dato)
            throws ServletException, IOException {
        Product ret=productManager.addProduct(dato);
        return ret;
    }
    @RequestMapping(value = "/productos/{id}",method = RequestMethod.GET)
    public Product showDatoById(@PathVariable String id)
            throws ServletException, IOException {
        Integer i= Integer.parseInt(id);
        return productManager.getProduct(i);
    }
    @RequestMapping(value = "/productos/{id}",method = RequestMethod.POST)
    public Product editDatoById(@PathVariable String id,@RequestBody Product dato)
            throws ServletException, IOException {
        if(Integer.parseInt(id)==dato.getId()) {
            productManager.addProduct(dato);
            return dato;
        }
        //return de fallo
        return dato;
    }
    @RequestMapping(value = "/productos/{id}",method = RequestMethod.DELETE)
    public Product deleteDatoById(@PathVariable String id)
            throws ServletException, IOException {
        Integer i= Integer.parseInt(id);
        Product p=productManager.getProduct(i);
        productManager.deleteProduct(i);
        return p;
    }
    /*
    @RequestMapping("/{player}")
    public String message(@PathVariable String player) {//REST Endpoint.
        return "Hello " + player;
    }
    */
}
