package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/email")
public class EmailController {
    @GetMapping ("/list")
    public ModelAndView showFormEmail(){
       ModelAndView modelAndView = new ModelAndView("list");
       modelAndView.addObject("email",new Email());
        modelAndView.addObject("languages", new String[] {"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSize", new int[] {5, 10, 15, 25, 50, 100});
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create (@ModelAttribute("email") Email email) {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("email1", email);
        return modelAndView;
    }
}
