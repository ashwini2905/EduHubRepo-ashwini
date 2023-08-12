package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.studententity.StudentEntity;
import com.example.student.studentservice.StudentServiceimpl;

@RestController

@RequestMapping("/lms")
public class StudentController {
	@Autowired
	StudentServiceimpl studentService;

	@PostMapping("/student")
	public StudentEntity studentdata(@RequestBody StudentEntity student) {
		return studentService.addstudent(student);

	}

	@GetMapping("/student/{id}")

	public StudentEntity getstudentdata(@PathVariable(value = "id") String id) {
		return studentService.getstudentById(id);

	}

	@PutMapping("/student/{id}")
	public StudentEntity updatedstudentdata(@RequestBody StudentEntity updatestudent) {
		return studentService.updatedstudentById(updatestudent);

	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deletestudentdata(@PathVariable(value = "id") String id) {
		studentService.deletestudentById(id);
		return new ResponseEntity<>("Student data Deleted Successfully", HttpStatus.OK);

	}

}
