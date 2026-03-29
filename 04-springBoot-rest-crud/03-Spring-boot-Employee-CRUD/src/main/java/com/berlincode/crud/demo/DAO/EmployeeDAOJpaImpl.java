package com.berlincode.crud.demo.DAO;

import com.berlincode.crud.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // Define fields for entity managers
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee" , Employee.class);

        //execute a query and get the result
        List<Employee> employees = theQuery.getResultList();

        //return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee theEmployee = entityManager.find(Employee.class , theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return saved employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class , theId);

        //remove the employee
        entityManager.remove(theEmployee);
    }
}
