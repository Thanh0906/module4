package com.codegym.repository;

import com.codegym.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IDivisionRepository extends JpaRepository<Division,Long> {
}
