package com.codegym.repository;

import com.codegym.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IServiceTypeRepository extends JpaRepository<ServiceType,Long> {
}
