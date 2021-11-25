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
import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerTypeServiceImpl customerTypeService;


    @ModelAttribute("customerType")
    public Iterable<CustomerType> getType() {
        return customerTypeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            return "redirect:/customer/list";
        }

    }

    @GetMapping("/list")
    public ModelAndView listCustomers(@RequestParam(value = "customerName", defaultValue = "", required = false) String customerName,
                                      @RequestParam(value = "customerPhone", defaultValue = "", required = false) String customerPhone,
                                      @RequestParam(value = "customerTypeId", defaultValue = "", required = false) String customerTypeId,
                                      @PageableDefault(size = 4) Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable, customerName, customerPhone, customerTypeId);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerList", customers);
        modelAndView.addObject("customerName", customerName);
        modelAndView.addObject("customerPhone", customerPhone);
        modelAndView.addObject("customerTypeId", customerTypeId);
        return modelAndView;
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model, @PageableDefault(value = 5) Pageable pageable) {
        customerService.remove(id);
        model.addAttribute("success", "Delete customer successfully !");
        Page<Customer> customerList = customerService.findAll(pageable);
        model.addAttribute("customerList", customerList);
        return "/customer/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customerDto", customerDto);
            modelAndView.addObject("customerType", customerTypeService.findAll());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            return "redirect:/customer/list";
        }
    }

}
