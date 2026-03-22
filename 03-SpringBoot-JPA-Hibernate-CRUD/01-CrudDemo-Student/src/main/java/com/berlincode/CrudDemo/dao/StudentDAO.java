package com.berlincode.CrudDemo.dao;

import com.berlincode.CrudDemo.entity.Student;
import org.hibernate.id.IntegralDataTypeHolder;

import java.util.List;

public interface StudentDAO {

    void save (Student theStudent);

    Student findById(Integer Id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(Integer Id);

    // MY WAY
//    void delete(Student theStudent);

    int deleteAll();
}
