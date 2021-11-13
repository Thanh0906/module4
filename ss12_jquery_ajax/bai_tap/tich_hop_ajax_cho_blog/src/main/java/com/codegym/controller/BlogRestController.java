package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    IBlogService blogService;

    //Xem danh sách blog
    @GetMapping("/blog")
    public List<Blog> getListBlog() {
        List<Blog> blogList = blogService.findAll();
        return blogList;
    }

    @GetMapping("/blog/ajax")
    public ModelAndView returnAJAXPage() {
        return new ModelAndView("/blog/blog_ajax");
    }

    //Xem chi tiết 1 blog
    @GetMapping("/blog/detail/{id}")
    public ResponseEntity<?> getDetailBlog(@PathVariable("id") Long id) {
        Blog blog = blogService.findById(id).get();
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    //Thêm mới 1 blog
    @PostMapping("/blog/create")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    //Update 1 blog
    @PatchMapping("/blog/update")
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Delete Blog
    @DeleteMapping("/blog/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }



    //tìm kiếm bằng web service
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Blog>> search(@PathVariable("title") String title
    ) {
        List<Blog> blogList = blogService.findByTitle(title);
        if (blogList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/showBlog")
    public ResponseEntity<Blog> showBlog(@PathVariable("id") Long id) {
        Optional<Blog> currentBlog = this.blogService.findById(id);

        if (currentBlog.isPresent()) {
            return new ResponseEntity<>(currentBlog.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
