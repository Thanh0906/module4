package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.model.CustomerType;

import com.codegym.service.impl.CustomerServiceImpl;
import com.codegym.service.impl.CustomerTypeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerTypeServiceImpl customerTypeService;

    @ModelAttribute("customerType")
    public Iterable<CustomerType> getType(){
        return  customerTypeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
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
    public ModelAndView listCustomers( @PageableDefault(size = 4) Pageable pageable){
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id")Long id, Model model, @PageableDefault(value = 10)Pageable pageable){
        customerService.remove(id);
        model.addAttribute("success","Delete customer successfully !");
        Page<Customer> customerList = customerService.findAll(pageable);
        model.addAttribute("customerList",customerList);
        return "/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id,Model model) {
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "/customer/edit";

    }
    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute("customerEdit") Customer customer, Model model) {
        customerService.save(customer);
        model.addAttribute("success", "Update customer successfully !");
        return "/customer/edit";
    }

}
