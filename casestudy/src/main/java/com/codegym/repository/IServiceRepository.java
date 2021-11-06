package com.codegym.repository;

import com.codegym.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Service
public interface IServiceRepository  extends JpaRepository<Service,Long> {
}
