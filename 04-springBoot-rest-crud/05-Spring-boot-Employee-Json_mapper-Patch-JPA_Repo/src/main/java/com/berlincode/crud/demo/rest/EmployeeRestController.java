package com.berlincode.crud.demo.rest;

import com.berlincode.crud.demo.entity.Employee;
import com.berlincode.crud.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

//    private EmployeeDAO employeeDAO;
//quick and dirty : inject employee DAO (use contructor injection)
//public EmployeeRestController(EmployeeDAO theEmployeeDAO){
//    employeeDAO = theEmployeeDAO;
//}
    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    public EmployeeRestController(EmployeeService theEmployeeService , JsonMapper theJsonMapper){
        employeeService = theEmployeeService;
        jsonMapper = theJsonMapper;
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
    //add mapping for POST/ employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // also just in case they pass Id in JSON.. Set Id to 0
        //this is just to force a save  of new item.. instead of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for PUT/employees - update an employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    //add mapping for PATCH
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayLoad){
        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception if null
        if(tempEmployee == null){
            throw new RuntimeException("Student ID doesn't exist " + employeeId);
        }

        //throw exception if request bodu contains ID
        if(patchPayLoad.containsKey("id")){
            throw new RuntimeException("Employee Id not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee , patchPayLoad);

        Employee dbEmployee = employeeService.save(patchedEmployee);
        return dbEmployee;
    }

    // add mapping for Delete
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee =employeeService.findById(employeeId);

        //throw e   xception if null
        if(tempEmployee == null){
            throw new RuntimeException("Employee Id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted Employee ID - " +employeeId ;
    }
}
