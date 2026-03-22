package com.berlincode.CrudDemo;

import com.berlincode.CrudDemo.dao.StudentDAO;
import com.berlincode.CrudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{

 			// createStudent(studentDAO);

			// createMultipleStudent(studentDAO);

			// readStudent(studentDAO);

			//queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get the list of the students
		List<Student> theStudents = studentDAO.findByLastName("mahato");

		//display the students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent.toString());
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get the student list
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent.toString());
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new Student object ...... ");
		Student tempStudent = new Student("daffy ", "duck" , "daffyduck@gmail.com");

		// save the student object
		System.out.println("Saving the newly created student object....");
		studentDAO.save(tempStudent);

		//	display id of the saved student
		System.out.println("Student saved with Generated Id : " + tempStudent.getId());

		//  retrieve student based on the ID :  Primary key
		System.out.println("\n Retrieving student by id : " +tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());

		//	display student
		System.out.println("Found the  Student : " + myStudent.toString());
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create multiple student
		System.out.println("Creating 3 Student object ...... ");
		Student tempStudent1  = new Student("Sergio ", "Marquina" , "berlinmarquina@gmail.com");
		Student tempStudent2  = new Student("Roshan ", "Mahato" , "roshanmahato@gmail.com");
		Student tempStudent3  = new Student("tanu ", "ladhe" , "tanuladddhe@gmail.com");

		//save that students objects
		System.out.println("Saving the Students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
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
