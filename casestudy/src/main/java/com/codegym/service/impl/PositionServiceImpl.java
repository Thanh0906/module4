package com.codegym.service.impl;

import com.codegym.model.Position;
import com.codegym.repository.IPositionRepository;
import com.codegym.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PositionServiceImpl implements IPositionService {
    @Autowired
    public IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(Long id) {
        return positionRepository.findById(id);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void remove(Long id) {
        positionRepository.deleteById(id);
    }
}
