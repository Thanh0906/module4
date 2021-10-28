package com.codegym.controller;

import com.codegym.model.Medical;
import com.codegym.repository.IMedicanRepository;
import com.codegym.service.IMedicalService;
import com.codegym.service.MedicalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping ("/medical")
public class MedicalController {
    private final IMedicalService medicalService =new MedicalServiceImpl();
   // @GetMapping("")
   //    public String index (Model model) {
   //        List<Medical> medicals = medicalService.findAll();
   //        model.addAttribute("medical", medicals);
   //        return "index";
   //    }
    @GetMapping ("")
    public ModelAndView showForm () {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("medical", new Medical());
        return modelAndView;
    }

    @PostMapping ("/save")
    public String save (@ModelAttribute Medical medical, Model model) {
        medical.setId((int) (Math.random()*10000));
        medicalService.save(medical);
        model.addAttribute("medical", medical);
        model.addAttribute("message", "Đã tạo tờ khai y tế thành công");
        return "info";
    }

    @GetMapping ("/{id}/edit")
    public String edit (@PathVariable int id, Model model) {
        model.addAttribute("medical", medicalService.findById(id));
        return "edit";
    }

    @PostMapping ("/update")
    public String update (Medical medical, Model model) {
        medicalService.update(medical.getId(), medical);
        model.addAttribute("message", "Đã cập nhật tờ khai y tế thành công");
        return "info";
    }
}