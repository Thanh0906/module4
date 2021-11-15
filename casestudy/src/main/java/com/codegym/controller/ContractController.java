package com.codegym.controller;

import com.codegym.model.Contract;
import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Service;
import com.codegym.service.impl.ContractServiceImpl;
import com.codegym.service.impl.CustomerServiceImpl;
import com.codegym.service.impl.EmployeeServiceImpl;
import com.codegym.service.impl.ServiceServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

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
    private ModelAndView list (@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("contract/list");
        modelAndView.addObject("contracts", contractService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@Valid @ModelAttribute Contract contract, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "contract/create";
        } else {
            contractService.save(contract);
            return "redirect:/contract";
        }
    }

    @PostMapping("/delete")
    public String delete (@RequestParam Long idContract) {
        contractService.remove(idContract);
        return "redirect:/contract";
    }
}
