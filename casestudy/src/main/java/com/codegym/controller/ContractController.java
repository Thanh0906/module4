package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.Contract;
import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Service;
import com.codegym.service.IContractService;
import com.codegym.service.ICustomerService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IServiceService;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;

    @ModelAttribute("employees")
    private Iterable<Employee> employees () {
        return employeeService.findAll();
    }

    @ModelAttribute("customers")
    private Iterable<Customer> customers () {
        return customerService.findAll();
    }

    @ModelAttribute("services")
    private Iterable<Service> services () {
        return serviceService.findAll();
    }

    @GetMapping("/list")
    private ModelAndView list (@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("contract/list");
        modelAndView.addObject("contractList", contractService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDto", new ContractDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@Valid @ModelAttribute ContractDto contractDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "contract/create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            return "redirect:/contract/list";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Contract> contract = contractService.findById(id);
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract.get(), contractDto);
        ModelAndView modelAndView;
        if (contractDto != null) {
            modelAndView = new ModelAndView("/contract/edit");
            modelAndView.addObject("contractDto", contractDto);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public String update (@Valid @ModelAttribute("contractDto") ContractDto contractDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "contract/edit";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            return "redirect:/contract/list";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model, @PageableDefault(value = 4) Pageable pageable) {
        contractService.remove(id);
        model.addAttribute("success", "Delete customer successfully !");
        Page<Contract> contracts = contractService.findAll(pageable);
        model.addAttribute("contractList", contracts);
        return "/customer/list";
    }
}
