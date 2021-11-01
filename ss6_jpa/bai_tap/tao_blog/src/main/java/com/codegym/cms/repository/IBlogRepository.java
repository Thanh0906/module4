package com.codegym.cms.repository;

import com.codegym.cms.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

}
