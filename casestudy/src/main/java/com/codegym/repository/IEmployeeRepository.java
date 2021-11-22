package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT * FROM employee WHERE name LIKE :name AND phone LIKE :phone ", nativeQuery = true)
    Page<Employee> findByNamePhone (Pageable pageable, @Param("name") String name,
                                        @Param("phone") String phone);
}
