package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping (value = "/product")
public class ProductController {

    private ProductServiceImpl productService;

    @GetMapping ("")
    public String index (Model model) {
        model.addAttribute("products", productService.findAll());
        return "/index";
    }

    @GetMapping ("/create")
    public String create (Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping ("/save")
    public String save (Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random()*10000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công.");
        return "redirect:/product";
    }

    @GetMapping ("/{id}/edit")
    public String edit (@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping ("/update")
    public String update (Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Sửa thành công.");
        return "redirect:/product";
    }

    @GetMapping ("/{id}/delete")
    public String delete (@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping ("/delete")
    public String delete (Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "XÓa thành công.");
        return "redirect:/product";
    }

    @GetMapping ("/{id}/view")
    public String view (@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping ("/search")
    public String search () {
        return "/search";
    }

    @PostMapping ("/searchByName")
    public String searchByName (Model model, @RequestParam (name = "search", required = false) String search) {
        List<Product> productList = null;
        if (StringUtils.hasText(search)) {
            productList = productService.searchByName(search);
            if (!productList.isEmpty()) {
                model.addAttribute("products", productList);
                model.addAttribute("message", productList.size() + " result");
            } else {
                model.addAttribute("message", "Not found");
            }
        } else {
            productList = productService.findAll();
            model.addAttribute("products", productList);
            model.addAttribute("message", productList.size() + " result");
        }
        return "/search";
    }
}
