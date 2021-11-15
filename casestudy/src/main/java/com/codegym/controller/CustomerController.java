package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.model.CustomerType;

import com.codegym.service.impl.CustomerServiceImpl;
import com.codegym.service.impl.CustomerTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerTypeServiceImpl customerTypeService;

    @ModelAttribute("customertypies")
    public Iterable<CustomerType> getType() {
        return customerTypeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listCustomers(@PageableDefault(size = 4) Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model, @PageableDefault(value = 4) Pageable pageable) {
        customerService.remove(id);
        model.addAttribute("success", "Delete customerDto successfully !");
        Page<Customer> customerList = customerService.findAll(pageable);
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }

    @GetMapping("/edit/{id}")
       public ModelAndView showEditForm(@PathVariable Long id) {
           Optional<Customer> customer = customerService.findById(id);

           if (customer != null) {
               ModelAndView modelAndView = new ModelAndView("/customer/edit");
               modelAndView.addObject("customer", customer);
               modelAndView.addObject("customerType",customerTypeService.findAll());
               return modelAndView;
           } else {
               ModelAndView modelAndView = new ModelAndView("/error.404");
               return modelAndView;
           }


       }
       @PostMapping("/edit")
       public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
           customerService.save(customer);
           ModelAndView modelAndView = new ModelAndView("/customer/edit");
           modelAndView.addObject("customer", customer);
           modelAndView.addObject("message", "Customer updated successfully");
           return modelAndView;
       }



}
