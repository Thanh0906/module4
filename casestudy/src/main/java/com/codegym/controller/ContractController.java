package com.codegym.controller;

import com.codegym.model.Contract;
import com.codegym.service.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/save")
    public String save (@ModelAttribute Contract contract) {
        contractService.save(contract);
        return "redirect:/contract";
    }
}
