package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    public ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }


    @Override
    public Page<Customer> findAll(Pageable pageable, String customer_name, String number_phone, String customer_type_id) {
        return customerRepository.findByNamePhoneTYpe(pageable,"%"+customer_name+"%","%"+number_phone+"%","%"+customer_type_id+"%");
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
