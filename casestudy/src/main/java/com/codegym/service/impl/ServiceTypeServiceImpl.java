package com.codegym.service.impl;

import com.codegym.model.ServiceType;
import com.codegym.repository.IServiceTypeRepository;
import com.codegym.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    public IServiceTypeRepository serviceRepository;


    @Override
    public List<ServiceType> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<ServiceType> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceRepository.save(serviceType);
    }

    @Override
    public void remove(Long id) {
        serviceRepository.deleteById(id);
    }
}
