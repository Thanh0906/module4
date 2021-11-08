package com.codegym.service.impl;

import com.codegym.model.ServiceType;
import com.codegym.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    public ServiceTypeServiceImpl serviceTypeService;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeService.findAll();
    }

    @Override
    public Optional<ServiceType> findById(Long id) {
        return serviceTypeService.findById(id);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeService.save(serviceType);
    }

    @Override
    public void remove(Long id) {
        serviceTypeService.remove(id);
    }
}
