package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("")
    public ModelAndView home(){
        ModelAndView andView =new ModelAndView("/layout");
        return andView;
    }
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView andView =new ModelAndView("/login");
        return andView;
    }
}
