package com.codegym.repository;

import com.codegym.module.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
}
