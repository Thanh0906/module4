package com.codegym.repository;

import com.codegym.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IContractRepository extends JpaRepository<Contract,Long> {
}
