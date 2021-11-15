package com.codegym.controller;

import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    public ICustomerService customerService;
    @GetMapping("")
    private ModelAndView getAllCustomer () {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customer", customerService.findALl());
        return modelAndView;
    }
    
}
