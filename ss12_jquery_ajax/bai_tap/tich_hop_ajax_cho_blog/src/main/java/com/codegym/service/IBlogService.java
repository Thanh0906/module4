package com.codegym.service;


import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService  extends IGeneralService<Blog>{
    Iterable<Blog> findAllByCategory(Category category);
    List<Blog> findByTitle(String title);
}
