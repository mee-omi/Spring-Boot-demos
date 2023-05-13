/**
 * 
 */
package com.techfreaks.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.ResourceUrlProviderExposingInterceptor;

import com.techfreaks.restdemo.entity.Student;

import jakarta.annotation.PostConstruct;

/**
 * @author Omkar
 */
@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> theStudents;

	@PostConstruct
	public void LoadData() {
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("John", "slay"));
		theStudents.add(new Student("Tony", "Stark"));
		theStudents.add(new Student("Valentino", "Rossi"));
	}

	// define endpoint for "/students" -return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}

	@GetMapping("students/{studentId}")
	public Student getStudent(@PathVariable Integer studentId) {
		System.out.println("studentId "+studentId);
		if (studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id not found " + studentId);
		}

		return theStudents.get(studentId);
	}

	// moving to global file 
	/*
	 * @ExceptionHandler
	 * public ResponseEntity<StudentErrorResponse>
	 * handleException(StudentNotFoundException stex) {
	 * StudentErrorResponse error = new StudentErrorResponse();
	 * error.setStatus(HttpStatus.NOT_FOUND.value());
	 * error.setMessage(stex.getMessage());
	 * error.setTimestamp(System.currentTimeMillis());
	 * return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 * }
	 * // add any exception handler
	 * @ExceptionHandler
	 * public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
	 * StudentErrorResponse error = new StudentErrorResponse();
	 * error.setStatus(HttpStatus.BAD_REQUEST.value());
	 * error.setMessage(ex.getMessage());
	 * error.setTimestamp(System.currentTimeMillis());
	 * return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	 * }
	 */
}
