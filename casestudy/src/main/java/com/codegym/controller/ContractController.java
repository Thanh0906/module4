package com.codegym.controller;

import com.codegym.model.Contract;
import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Service;
import com.codegym.service.IContractService;
import com.codegym.service.ICustomerService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public IContractService contractService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IServiceService iService;

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
    public ModelAndView showCreateContract() {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveContract(@ModelAttribute("contract") Contract contract) {
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contract", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        Optional<Contract> contract = contractService.findById(id);
//
//        if (contract != null) {
//            ModelAndView modelAndView = new ModelAndView("/contract/edit");
//            modelAndView.addObject("contractEdit", contract);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//
//
//    }
//    @PostMapping("/edit")
//    public ModelAndView updateCustomer(@ModelAttribute("contractEdit") Contract contract) {
//        contractService.save(contract);
//        ModelAndView modelAndView = new ModelAndView("/contract/edit");
//        modelAndView.addObject("contractEdit",contract);
//        modelAndView.addObject("message", "Customer updated successfully");
//        return modelAndView;
//    }
//
//    @PostMapping("/delete")
//    public String delete (@RequestParam Long idContract) {
//        contractService.remove(idContract);
//        return "redirect:/contract";
//    }
}
