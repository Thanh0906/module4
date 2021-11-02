package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "New category was successful created");
        return "redirect:/category";
    }

    @GetMapping("")
    public ModelAndView listBlog() {
        Iterable<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        ModelAndView modelAndView;
        if (category.isPresent()) {
            modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category.get());
            return modelAndView;
        } else {
            modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }

    }

    @PostMapping("/update")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Update thành công");

      return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("message","xóa thành công");
        return "redirect:category";
    }



}
