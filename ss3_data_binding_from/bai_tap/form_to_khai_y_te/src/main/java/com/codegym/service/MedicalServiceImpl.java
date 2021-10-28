package com.codegym.service;

import com.codegym.model.Medical;
import com.codegym.repository.IMedicanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicalServiceImpl implements IMedicalService {
    @Autowired
    private IMedicanRepository medicalRepository;

    @Override
    public List<Medical> findAll() {
        return medicalRepository.findAll();
    }

    @Override
    public void save(Medical medical) {
        medicalRepository.save(medical);
    }

    @Override
    public Medical findById(int id) {
        return medicalRepository.findById(id);
    }

    @Override
    public void update(int id, Medical medical) {
        medicalRepository.update(id, medical);
    }
}
