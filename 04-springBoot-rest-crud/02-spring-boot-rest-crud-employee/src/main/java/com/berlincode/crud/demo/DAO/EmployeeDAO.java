package com.berlincode.crud.demo.DAO;

import com.berlincode.crud.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
