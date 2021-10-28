package com.codegym.repository;

import com.codegym.model.Medical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalRepositoryImpl implements IMedicanRepository{
    Map<Integer, Medical> medicalList = new HashMap<>();

    @Override
    public List<Medical> findAll() {
        return new ArrayList<>(medicalList.values());
    }

    @Override
    public void save(Medical medical) {
        medicalList.put(medical.getId(), medical);
    }

    @Override
    public Medical findById(int id) {
        return medicalList.get(id);
    }

    @Override
    public void update(int id, Medical medical) {
        medicalList.put(id, medical);
    }
}
