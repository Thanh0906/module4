package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.service.impl.EmployeeServiceImpl;
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

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    public EmployeeServiceImpl employeeService;
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
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listCustomers( @PageableDefault(size = 4) Pageable pageable){
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id")Long id, Model model, @PageableDefault(value = 10)Pageable pageable){
        employeeService.remove(id);
        model.addAttribute("success","Delete customer successfully !");
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employee",employees);
        return "/employee/list";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        ModelAndView modelAndView;
        if (employee!= null) {
            modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }
    @PostMapping("/update")
    public String update ( @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "employee/edit";
        } else {
            Employee employee1 = new Employee();
            BeanUtils.copyProperties(employee, employee1);
            employeeService.save(employee);
            return "redirect:/employee";
        }
    }

}
