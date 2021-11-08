package com.codegym.controller;

import com.codegym.model.ContractDetail;
import com.codegym.service.impl.AttachServiceServiceImpl;
import com.codegym.service.impl.ContractDetailServiceImpl;
import com.codegym.service.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    public ContractDetailServiceImpl contractDetailService;
    @Autowired
    public AttachServiceServiceImpl attachService;
    @Autowired
    public ContractServiceImpl contractService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/contract-detail/list");
        modelAndView.addObject("services", contractDetailService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("contract-detail/create");
        modelAndView.addObject("service", new ContractDetail());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return "redirect:/contract-detail";

    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contractDetailEdit", contractDetailService.findById(id));
        return "/contract_detail/edit";
    }

    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute("contractDetailEdit") ContractDetail contractDetail, Model model) {
        contractDetailService.save(contractDetail);
        model.addAttribute("success", "Update contract successfully !");
        return "/contract_detail/edit";
    }
}
