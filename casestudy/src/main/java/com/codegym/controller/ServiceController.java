package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.impl.RentTypeServiceImpl;
import com.codegym.service.impl.ServiceServiceImpl;
import com.codegym.service.impl.ServiceTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    public ServiceServiceImpl serviceService;
    @Autowired
    ServiceTypeServiceImpl  serviceTypeService;
    @Autowired
    RentTypeServiceImpl rentTypeService;

    @ModelAttribute("rentTypies")
    public Iterable<RenType> getRentTypies() {
        return rentTypeService.findAll();
    }

    @ModelAttribute("serviceTypies")
    public Iterable<ServiceType> getServiceTypies() {
        return serviceTypeService.findAll();
    }

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

    @PostMapping("/create")
    public ModelAndView saveService(@ModelAttribute("employee") Service service) {
        serviceService.save(service);
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("message", "New Service created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("serviceEdit", serviceService.findById(id));
        return "/service/edit";
    }

    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute("serviceEdit") Service service, Model model) {
        serviceService.save(service);
        model.addAttribute("success", "Update service successfully !");
        return "/service/edit";
    }
}
