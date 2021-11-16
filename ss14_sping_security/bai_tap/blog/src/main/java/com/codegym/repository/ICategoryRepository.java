package com.codegym.repository;

import com.codegym.module.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
