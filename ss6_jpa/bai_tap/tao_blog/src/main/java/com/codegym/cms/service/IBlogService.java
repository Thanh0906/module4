package com.codegym.cms.service;

import com.codegym.cms.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById (Long id);
    void saveOrUpdate (Blog blog);
    void delete (Long id);
}
