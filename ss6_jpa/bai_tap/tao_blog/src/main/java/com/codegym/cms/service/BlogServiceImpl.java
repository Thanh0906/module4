package com.codegym.cms.service;

import com.codegym.cms.model.Blog;
import com.codegym.cms.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Blog blog) {
        blogRepository.saveOrUpdate(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }
}
