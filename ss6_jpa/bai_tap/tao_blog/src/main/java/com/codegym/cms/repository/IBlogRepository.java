package com.codegym.cms.repository;

import com.codegym.cms.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    Blog findById (Long id);
    void saveOrUpdate (Blog blog);
    void delete (Long id);
}
