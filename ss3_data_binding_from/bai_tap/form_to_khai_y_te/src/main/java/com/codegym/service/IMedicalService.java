package com.codegym.service;

import com.codegym.model.Medical;

import java.util.List;

public interface IMedicalService {
    List<Medical> findAll ();
    void save (Medical medicalDeclaration);
    Medical findById (int id);
    void update (int id, Medical medicalDeclaration);
}
