package com.atos.eduhub.service;

import java.util.List;

import com.atos.eduhub.model.CourseModel;

public interface CourseService {

	public CourseModel addCourse(CourseModel newCourse) throws Exception;

	public CourseModel updateCourse(CourseModel updateCourse) throws Exception;

	public void deleteCourse(String id) throws Exception;

	public List<CourseModel> getAllCourse() throws Exception;

	public CourseModel getCourseById(String id) throws Exception;

	public String deleteAllCourse() throws Exception;

	long getCountOfAllCourse() throws Exception;

	String getallData() throws Exception;
}
