package com.codegym.controller;

import com.codegym.model.RentType;
import com.codegym.model.Service;
import com.codegym.model.ServiceType;
import com.codegym.service.IRenTypeService;
import com.codegym.service.IServiceService;
import com.codegym.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    public IServiceService serviceService;
    @Autowired
    IServiceTypeService  serviceTypeService;
    @Autowired
    IRenTypeService rentTypeService;

    @ModelAttribute("rentTypeList")
    public Iterable<RentType> getRentType() {
        return rentTypeService.findAll();
    }

    @ModelAttribute("serviceTypeList")
    public Iterable<ServiceType> getServiceType() {
        return serviceTypeService.findAll();
    }


    @GetMapping("/list")
    public ModelAndView listService(@PageableDefault(size =4)Pageable pageable) {
        Page<Service> services = serviceService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/service/list");
        modelAndView.addObject("services",services);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveService(@ModelAttribute("service") Service service) {
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
        return "/service/list";
    }
}
