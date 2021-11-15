package com.codegym.service.impl;

import com.codegym.model.RentType;
import com.codegym.repository.IRentTypeRepository;
import com.codegym.service.IRenTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RentTypeServiceImpl implements IRenTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Optional<RentType> findById(Long id) {
        return rentTypeRepository.findById(id);
    }

    @Override
    public void save(RentType renType) {
rentTypeRepository.save(renType);
    }

    @Override
    public void remove(Long id) {
rentTypeRepository.deleteById(id);
    }
}
