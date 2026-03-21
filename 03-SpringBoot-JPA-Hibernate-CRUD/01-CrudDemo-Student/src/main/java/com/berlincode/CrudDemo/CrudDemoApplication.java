package com.berlincode.CrudDemo;

import com.berlincode.CrudDemo.dao.StudentDAO;
import com.berlincode.CrudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
//		create the student object
		System.out.println("Creating new Student object ...... ");
		Student tempStudent = new Student("Berlin ", "Marquina" , "berlinmarquina@gmail.com");

//		save the student object
		System.out.println("Saving the newly created student object....");
		studentDAO.save(tempStudent);

//		display id of the saved student
		System.out.println("Saved Student. Generated id:" + tempStudent.getId());
	}
}
