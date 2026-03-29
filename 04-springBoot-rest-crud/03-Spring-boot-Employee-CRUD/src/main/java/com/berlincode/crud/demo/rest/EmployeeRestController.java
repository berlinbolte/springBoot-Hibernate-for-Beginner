package com.berlincode.crud.demo.rest;

import com.berlincode.crud.demo.DAO.EmployeeDAO;
import com.berlincode.crud.demo.entity.Employee;
import com.berlincode.crud.demo.service.EmployeeService;
import com.berlincode.crud.demo.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

//    private EmployeeDAO employeeDAO;
//quick and dirty : inject employee DAO (use contructor injection)
//public EmployeeRestController(EmployeeDAO theEmployeeDAO){
//    employeeDAO = theEmployeeDAO;
//}
    private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findALl(){
        return employeeService.findAll();
    }

    // add mapping for GET/employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee Id not found - " + employeeId);
        }
        return theEmployee;
    }
}
