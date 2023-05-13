package com.example.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;

/**
 * @author Omkar
 *         Stand alone application
 */
@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	/**
	 * Executed after spring beans have beem laoded
	 * runner has custom code
	 * 
	 * @param args
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			// System.out.println("Hello world");
			 //createStudent(studentDao);
			 createMultipleStudents(studentDao);
			// readStudent(studentDao);
			// queryForStudents(studentDao);
			// queryForStudentsByLastName(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			//deleteAllStudents(studentDao);
		};
	}

	/**
	 * @param studentDao
	 */
	private void createMultipleStudents(StudentDAO studentDao) {
		// TODO Auto-generated method stub
		System.out.println("creating multiple student");
		Student tempStudent1 = new Student("Ael 11", "Toe", "awel.towa@gmail.com");
		Student tempStudent2 = new Student("Bel 11", "Yoe", "bwel.yowa@gmail.com");
		Student tempStudent3 = new Student("Cel 11", "doe", "cwel.dowa@gmail.com");
		Student tempStudent4 = new Student("Del 11", "woe", "dwel.Wsowa@gmail.com");

		// save student object
		System.out.println("saving student");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);
		studentDao.save(tempStudent4);

		// display id of saved student
		System.out.println("saved student generated id " + tempStudent1.getId());

	}

	/**
	 * @param studentDao
	 */
	private void deleteAllStudents(StudentDAO studentDao) {
		// TODO Auto-generated method stub
		System.out.println("deleting all students");
		int numRows = studentDao.deleteAll();
		System.out.println(" Deleted row count :"+numRows);
	}

	/**
	 * @param studentDao
	 */
	private void deleteStudent(StudentDAO studentDao) {
		// TODO Auto-generated method stub
		int delStudentId = 3;
		studentDao.delete(delStudentId);
		System.out.println("deleted student with id 3");
	}

	/**
	 * @param studentDao
	 */
	private void updateStudent(StudentDAO studentDao) {
		// TODO Auto-generated method stub
		int studentId = 1;

		Student myStudent = studentDao.findById(1);

		myStudent.setFirstName("Bosco");

		studentDao.update(myStudent);

		System.out.println(myStudent);
	}

	/**
	 * @param studentDao
	 */
	private void queryForStudentsByLastName(StudentDAO studentDao) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// get list of students
		List<Student> students = studentDao.findByLastName("Toe");

		// display list of students
		for (Student stud : students) {
			System.out.println(stud);
		}
	}

	/**
	 * @param studentDao
	 */
	private void queryForStudents(StudentDAO studentDao) {
		// TODO Auto-generated method stub
		// get list of students
		List<Student> students = studentDao.findAll();

		// display list of students
		for (Student stud : students) {
			System.out.println(stud);
		}
	}

	/**
	 * @param studentDao
	 */
	private void readStudent(StudentDAO studentDao) {
		// TODO Auto-generated method stub
		System.out.println("creating student object");
		Student tmepStudent = new Student("ads", "asdas", "saaf@ioij.com");

		studentDao.save(tmepStudent);

		int studId = tmepStudent.getId();

		Student myStudent = studentDao.findById(studId);

		System.out.println("found the student " + myStudent);
	}

	/**
	 * @param studeDao
	 */
	private void createStudent(StudentDAO studentDao) {
		// TODO Auto-generated method stub
		// create student object
		System.out.println("creating new student");
		Student tempStudent = new Student("Bel 11", "Toe", "dwel.towa@gmail.com");

		// save student object
		System.out.println("saving student");
		studentDao.save(tempStudent);

		// display id of saved student
		System.out.println("saved student generated id " + tempStudent.getId());
	}
}
