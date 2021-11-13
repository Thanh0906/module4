package com.codegym.controller;

import com.codegym.model.SmartPhone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SmartPhoneController {
    @Autowired
    ISmartphoneService iSmartphoneService;

    @PostMapping("/create")
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(iSmartphoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ModelAndView returnList() {
        return new ModelAndView("/phones/list");
    }

    @GetMapping("/listPhone")
    public ResponseEntity<List<SmartPhone>> allPhones() {
        List<SmartPhone> phones = iSmartphoneService.findAll();
        return new ResponseEntity<>(phones, HttpStatus.OK);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<SmartPhone> findById(@PathVariable("id") Long id){
        SmartPhone phone = iSmartphoneService.findById(id).get();
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<SmartPhone> update(@RequestBody SmartPhone smartPhone){
        iSmartphoneService.update(smartPhone);
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }
}
