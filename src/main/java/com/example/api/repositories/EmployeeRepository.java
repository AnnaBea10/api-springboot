package com.example.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
