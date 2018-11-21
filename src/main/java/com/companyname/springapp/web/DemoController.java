package com.companyname.springapp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class DemoController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value="/demo.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Returning hello view");
        Date f= new Date();
        return new ModelAndView("demo.jsp","fecha",f);
    }
    @RequestMapping(value="/add.htm")
    public ModelAndView addRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("Returning hello view");
        Date f= new Date();
        return new ModelAndView("add.jsp","fecha",f);
    }
}
