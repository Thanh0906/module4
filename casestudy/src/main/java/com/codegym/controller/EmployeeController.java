package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
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
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    @ModelAttribute("userList")
    public Iterable<User> getUser(){return iUserService.findAll();}


    @GetMapping("/list")
    public ModelAndView listEmployee(@RequestParam(value = "name", defaultValue = "", required = false) String name,
                                     @RequestParam(value = "phone", defaultValue = "", required = false) String phone,
                                     @PageableDefault(size = 4) Pageable pageable) {
        Page<Employee> employees = employeeService.finByNamePhone(pageable, name, phone);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employeeList", employees);
        modelAndView.addObject("name", name);
        modelAndView.addObject("phone", phone);
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "/employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee.get(), employeeDto);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employeeDto", employeeDto);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            return "redirect:/employee/list";
        }


    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model, @PageableDefault(value = 5) Pageable pageable) {
        employeeService.remove(id);
        model.addAttribute("success", "Delete customer successfully !");
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employeeList", employees);
        return "/employee/list";
    }
}


