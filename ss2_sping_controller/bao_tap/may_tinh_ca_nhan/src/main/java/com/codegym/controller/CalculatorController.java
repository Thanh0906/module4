package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping
    public String calculator(){
        return "/calculator";
    }
    @PostMapping
    public String calculate (@RequestParam (name = "first") double first,
                             @RequestParam (name = "second") double second,
                             @RequestParam (name = "calculate") String calculate,
                             Model model){
        double result = 0;
        if(calculate.equals("Addition(+)")){
            result = first + second;
            model.addAttribute("result",result);
        }
        if(calculate.equals("Subtraction(-)")){
            result = first - second;
            model.addAttribute("result",result);
        }
        if(calculate.equals("Multiplication(X)")){
            result = first * second;
            model.addAttribute("result",result);
        }
        if(calculate.equals("Division(/)")){
            if(second != 0) {
                result = first / second;
                model.addAttribute("result", result);
            }else {
                String err = "Mẫu số phải khác 0";
                model.addAttribute("result",err);
            }
        }
        model.addAttribute("first",first);
        model.addAttribute("second",second);
        return "calculator";

    }
}
