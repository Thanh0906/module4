package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import com.codegym.service.impl.CustomerServiceImpl;
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
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        ModelAndView modelAndView;
        if (customer != null) {
            modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }
    @PostMapping("/update")
    public String update ( @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "customer/edit";
        } else {
            Customer customers = new Customer();
            BeanUtils.copyProperties(customer, customers);
            customerService.save(customer);
            return "redirect:/customer";
        }
    }

}
