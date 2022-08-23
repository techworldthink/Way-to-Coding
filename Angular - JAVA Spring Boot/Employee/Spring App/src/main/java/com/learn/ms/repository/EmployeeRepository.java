package com.learn.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.ms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
