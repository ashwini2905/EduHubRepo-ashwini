package com.atos.eduhub.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.atos.eduhub.exception.CourseNotFoundException;
import com.atos.eduhub.model.CourseModel;
import com.atos.eduhub.service.CourseService;

@RestController
@RequestMapping("/lms")
public class CourseController {

	@Autowired(required = true)
	CourseService courseService;

	// API to insert course
	/*
	 * URL : localhost:8080/lms/course { "coursename": "Java", "coursedescription":
	 * "coursedescription", "skillrequired": "basics of java" }
	 */
	@PostMapping("/course")
	public ResponseEntity<CourseModel> addCourse(@Valid @RequestBody CourseModel newCourse)
			throws CourseNotFoundException, Exception {
		try {
			CourseModel updateCourseModel = courseService.addCourse(newCourse);
			return ResponseEntity.ok(updateCourseModel);
		} catch (Exception e) {
			throw e;
		}
	}

	// API to update course
	/*
	 * URL : localhost:8080/lms/course/63c07eb9144f057cafc0c6e6 { "courseid":
	 * "63c07eb9144f057cafc0c6e6", "coursename": "Java, servlet",
	 * "coursedescription": "coursedescription", "skillrequired": "basics of java" }
	 */
	@PutMapping("/course")
	public ResponseEntity<CourseModel> updateCourse(@Valid @RequestBody CourseModel updateCourse)
			throws CourseNotFoundException, Exception {
		try {
			CourseModel result = courseService.updateCourse(updateCourse);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (CourseNotFoundException e) {
			throw new CourseNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw e;
		}

	}

	// API to delete course
	/*
	 * URL : localhost:8080/lms/course/63c07eb9144f057cafc0c6e6
	 */
	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable(value = "id") String id) throws Exception {

		try {
			courseService.deleteCourse(id);
			return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
		} catch (CourseNotFoundException e) {
			throw new CourseNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw e;
		}
	}

	// API to delete all course
	/*
	 * URL : localhost:8080/lms/deleteAllCourse
	 */
	@DeleteMapping("/deleteAllCourse")
	public ResponseEntity<String> deleteAllCourse() throws Exception {

		try {
			String result = courseService.deleteAllCourse();
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (CourseNotFoundException e) {
			throw new CourseNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw e;
		}

	}

	// API to get all course
	/*
	 * URL : localhost:8080/lms/course
	 */
	@GetMapping("/course")
	public List<CourseModel> getAllCourse() throws Exception {
		try {
			return courseService.getAllCourse();
		} catch (Exception e) {
			throw e;
		}
	}

	// API to get course by CourseId
	/*
	 * URL : localhost:8080/lms/course/63c07eb9144f057cafc0c6e6
	 */
	@GetMapping("/course/{id}")
	public ResponseEntity<CourseModel> getCourseById(@PathVariable(value = "id") String id)
			throws CourseNotFoundException, Exception {
		CourseModel result;
		try {
			result = courseService.getCourseById(id);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (CourseNotFoundException e) {
			throw new CourseNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/run-dbtask")
	public String getAll() throws Exception {
		try {
			return courseService.getallData();
		} catch (Exception e) {
			throw e;
		}
	}

}
