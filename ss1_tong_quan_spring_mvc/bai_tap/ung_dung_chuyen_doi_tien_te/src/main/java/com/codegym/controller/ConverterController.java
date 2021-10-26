package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping ("/convert")
    public String convert () {
        return "/convert";
    }

    @PostMapping ("/convert")
    public String save (@RequestParam (name = "usd") double usd, @RequestParam (name = "vnd") double vnd, Model model) {
        double result = usd * vnd;
        model.addAttribute("result", result);
        return "/convert";
    }
}
