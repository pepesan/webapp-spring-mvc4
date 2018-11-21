package com.companyname.springapp.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


public class HelloControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hello.jsp", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Date nowValue = (Date) modelAndView.getModel().get("fecha");
        assertNotNull(nowValue);

    }

}