package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/world-clock")
    public String getTimeByTimeZone(ModelMap modelMap, @RequestParam(name = "city",required = false,defaultValue = "Asia/Ho_Chi_Minh")String city){
        Date date =new Date();
        TimeZone timeZone =TimeZone.getDefault();
        TimeZone zone =TimeZone.getTimeZone(city);
        long locale =date.getTime()+(zone.getRawOffset()-timeZone.getRawOffset());
        date.setTime(locale);
        modelMap.addAttribute("city",city);
        modelMap.addAttribute("date",date);
        return "index";
    }
}
