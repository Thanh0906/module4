package com.codegym.repository;

import com.codegym.model.RenType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RenType,Long> {
}
