package com.berlincode.crud.demo.service;

import com.berlincode.crud.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
