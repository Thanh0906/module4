package com.codegym.service;


import com.codegym.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService  extends IGeneralService<Service>{
    Page<Service> findAll(Pageable pageable);
}
