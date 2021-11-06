package com.codegym.controller;

import com.codegym.model.Service;
import com.codegym.service.impl.ServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    public ServiceServiceImpl serviceService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/service/list");
        modelAndView.addObject("services", serviceService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute Service service) {
       serviceService.save(service);
        return "redirect:/service";
    }
}
