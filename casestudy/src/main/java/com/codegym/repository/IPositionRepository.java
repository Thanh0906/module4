package com.codegym.repository;

import com.codegym.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IPositionRepository extends JpaRepository<Position,Long> {
}
