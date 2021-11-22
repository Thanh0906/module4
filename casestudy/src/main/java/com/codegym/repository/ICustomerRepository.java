package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT * FROM customer WHERE customer_name LIKE :customer_name AND number_phone LIKE :number_phone " +
            "AND customer_type_id LIKE :customer_type_id", nativeQuery = true)
    Page<Customer> findByNamePhoneTYpe (Pageable pageable, @Param("customer_name") String customer_name,
                            @Param("number_phone") String customer_phone, @Param("customer_type_id") String customer_type_id);
}
