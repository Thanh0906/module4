package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    public BlogServiceImpl blogService;
    //trả về danh sách khách hàng
    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAllBlog() {
        List<Blog> customers = (List<Blog>) blogService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    //trả về blog với id=?
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
    //với một JSON object tạo một blog mới dùng @PostMapping
    @PostMapping
    public ResponseEntity<Blog> saveCustomer(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }
//"  cập nhật dùng  @PutMapping("/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<Blog> update (@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
    }
    //xóa dùng   @DeleteMapping("/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteById (@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blog.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Blog>> page(@RequestParam int page,int value){
        Page<Blog> blogs = blogService.blog(PageRequest.of(page,value));
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

}
