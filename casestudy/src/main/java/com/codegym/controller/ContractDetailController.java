package com.codegym.controller;

import com.codegym.model.ContractDetail;
import com.codegym.service.impl.ContractDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    public ContractDetailServiceImpl contractService;
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/contract-detail/list");
        modelAndView.addObject("services", contractService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("contract-detail/create");
        modelAndView.addObject("service", new ContractDetail());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute ContractDetail contractDetail) {
        contractService.save(contractDetail);
        return "redirect:/contract-detail";
    }
}
