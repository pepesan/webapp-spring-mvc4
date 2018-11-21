package com.companyname.springapp.web;

import com.companyname.springapp.web.domain.Product;
import com.companyname.springapp.web.service.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CrudController {

    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    ProductManager productManager;

    @RequestMapping(value="/listado.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Returning hello view");
        List<Product> listado= productManager.getProducts();
        return new ModelAndView("crud/listado.jsp","productos",listado);
    }
    @RequestMapping(value="/form.htm")
    public ModelAndView formHandleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Returning hello view");
        Date f= new Date();

        return new ModelAndView("crud/form.jsp","fecha",f);
    }
}
