package com.codegym.repository;

import com.codegym.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ContractDetailRepository extends JpaRepository<ContractDetail,Long> {
}
