package com.berlincode.CrudDemo.dao;

import com.berlincode.CrudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save (Student theStudent);
    Student findById(Integer Id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
}
