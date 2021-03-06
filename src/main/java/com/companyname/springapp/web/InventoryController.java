package com.companyname.springapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.companyname.springapp.web.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.web.service.ProductManager;

@Controller
public class InventoryController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;

    @RequestMapping(value="/list.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        List<Product> listado=this.productManager.getProducts();
        //listado.add(new Product());
        myModel.put("products", listado);

        return new ModelAndView("list.jsp", "model", myModel);
    }
    @RequestMapping(value="/addl.htm")
    public ModelAndView addRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Map<String, Object> myModel = new HashMap<String, Object>();
        this.productManager.addProduct(new Product());
        List<Product> listado=this.productManager.getProducts();
        myModel.put("products", listado);

        return new ModelAndView("addl.jsp", "model", myModel);
    }


    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
