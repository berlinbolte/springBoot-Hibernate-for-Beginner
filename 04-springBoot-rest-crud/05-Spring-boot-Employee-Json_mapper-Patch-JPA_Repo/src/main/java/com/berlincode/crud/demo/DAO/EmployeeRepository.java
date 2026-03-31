package com.berlincode.crud.demo.DAO;

import com.berlincode.crud.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
    // that's It no need to write any other code LOL
}
