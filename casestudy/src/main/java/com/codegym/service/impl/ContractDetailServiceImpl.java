package com.codegym.service.impl;

import com.codegym.model.ContractDetail;
import com.codegym.repository.ContractDetailRepository;
import com.codegym.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Optional<ContractDetail> findById(Long id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Long id) {
contractDetailRepository.deleteById(id);
    }
}
