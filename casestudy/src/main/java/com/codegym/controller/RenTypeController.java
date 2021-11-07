package com.codegym.controller;

import com.codegym.model.RenType;
import com.codegym.service.impl.RentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/rent-type")
public class RenTypeController {
    @Autowired
    private RentTypeServiceImpl rentTypeService;

    @GetMapping("")
    private ModelAndView list () {
        ModelAndView modelAndView = new ModelAndView("rent-type/list");
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("rent-type/create");
        modelAndView.addObject("rentType", new RenType());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute RenType renType) {
        rentTypeService.save(renType);
        return "redirect:/rent-type";
    }
}
