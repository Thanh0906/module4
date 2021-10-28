package com.codegym.repository;

import com.codegym.model.Medical;

import java.util.List;

public interface IMedicanRepository {
    List<Medical> findAll ();
    void save (Medical medical);
    Medical findById (int id);
    void update (int id, Medical medical);
}
