package com.codegym.cms.service;

import com.codegym.cms.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogService  {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void delete(int id);

}
