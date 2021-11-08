package com.codegym.controller;

import com.codegym.model.Contract;
import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Service;
import com.codegym.service.impl.ContractServiceImpl;
import com.codegym.service.impl.CustomerServiceImpl;
import com.codegym.service.impl.EmployeeServiceImpl;
import com.codegym.service.impl.ServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    public ContractServiceImpl contractService;
    @Autowired
    CustomerServiceImpl iCustomerService;
    @Autowired
    EmployeeServiceImpl iEmployeeService;
    @Autowired
    ServiceServiceImpl iService;

    @ModelAttribute("customerList")
    public Iterable<Customer> getCustomerList() {
        return iCustomerService.findAll();
    }
    @ModelAttribute("employeeList")
    public Iterable<Employee> getEmployeeList() {
        return iEmployeeService.findAll();
    }
    @ModelAttribute("serviceList")
    public Iterable<Service> getServiceList() {
        return iService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView list() {

        ModelAndView modelAndView = new ModelAndView("/contract/list");
        modelAndView.addObject("contract", contractService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }


    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("contract") Contract contract) {
       contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("message", "New contract created successfully");
        return modelAndView;
    }
}
