package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.IUserService;
import com.codegym.service.impl.DivisionServiceImpl;
import com.codegym.service.impl.EducationDegreeServiceImpl;
import com.codegym.service.impl.EmployeeServiceImpl;
import com.codegym.service.impl.PositionServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    public EmployeeServiceImpl employeeService;
    @Autowired
    public DivisionServiceImpl iDivisionService;
    @Autowired
    public PositionServiceImpl iPositionService;
    @Autowired
    EducationDegreeServiceImpl iEducationService;
    @Autowired
    IUserService iUserService;
    @ModelAttribute("divisionList")
    public Iterable<Division> getDivision() {
        return iDivisionService.findAll();
    }

    @ModelAttribute("positionList")
    public Iterable<Position> getPosition() {
        return iPositionService.findAll();
    }

    @ModelAttribute("educationList")
    public Iterable<EducationDegree> getEducation() {
        return iEducationService.findAll();
    }


    @GetMapping("/list")
    public String showIndex(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Employee> employeeList = employeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "/employee/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employeeList", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Employee> employeeEdit = employeeService.findById(id);
        model.addAttribute("employeeEdit", employeeEdit);
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute("employeeEdit") Employee employee, Model model) {
        employeeService.save(employee);
        model.addAttribute("success", "Update customer successfully !");
        return "/employee/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model, @PageableDefault(value = 5) Pageable pageable) {
        employeeService.remove(id);
        model.addAttribute("success", "Delete employee successfully !");
        Page<Employee> employeeList = employeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "/employee/list";
    }
}


