package com.g2c6.kafkaproducer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g2c6.kafkaproducer.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
