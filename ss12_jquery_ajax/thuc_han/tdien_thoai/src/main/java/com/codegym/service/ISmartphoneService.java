package com.codegym.service;

import com.codegym.model.Smartphone;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
}
