package com.atos.eduhub.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.eduhub.dao.CourseDao;
import com.atos.eduhub.exception.CourseException;
import com.atos.eduhub.exception.CourseNotFoundException;
import com.atos.eduhub.model.CourseModel;
import com.atos.eduhub.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;

	@Override
	public CourseModel addCourse(CourseModel newCourse) throws Exception {
		CourseModel savedCourse = courseDao.save(newCourse);
		return (savedCourse);

	}

	@Override
	public CourseModel updateCourse(CourseModel updateCourse) throws Exception {
		getCourseById(updateCourse.getCourseID());
		CourseModel updatedCourse = courseDao.save(updateCourse);
		return updatedCourse;
	}

	@Override
	public void deleteCourse(String id) throws Exception {
		CourseModel coursemodel = getCourseById(id);
		courseDao.deleteById(coursemodel.getCourseID());
	}

	@Override
	public List<CourseModel> getAllCourse() throws Exception {
		List<CourseModel> allCourses = courseDao.findAll();
		return allCourses;
	}

	@Override
	public CourseModel getCourseById(String id) throws Exception {

		Optional<CourseModel> courseData = courseDao.findById(id);

		if (courseData.isPresent()) {
			return courseData.get();
		} else {
			throw new CourseNotFoundException("Course Not Found");
		}

	}

	@Override
	public String deleteAllCourse() throws Exception {
		if (getCountOfAllCourse() > 0) {
			courseDao.deleteAll();
			return "All Course deleted successfully";
		} else {
			throw new CourseNotFoundException("Course/s Not Found");
		}

	}

	@Override
	public long getCountOfAllCourse() throws Exception {
		try {
			return courseDao.count();
		} catch (Exception e) {
			throw new CourseException(e.getMessage());
		}
	}
	
	@Override
	public String getallData() throws Exception {
		try {
			File file = new File("F:\\myselfexcelbook.xlsx");
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			Workbook workbook  = new XSSFWorkbook(fis);
			int numberOfSheets = workbook.getNumberOfSheets();
			Sheet sheet = workbook.getSheetAt(0);  
			Iterator<Row> itr = sheet.iterator(); 
			while (itr.hasNext())                 
			{  
			Row row = itr.next();  
			Iterator<Cell> cellIterator = row.cellIterator();
			}
			
		  System.out.println("How many sheet present in  excel now " + numberOfSheets);
		  return "Excel data updated";
		} catch (Exception e) {
			throw new CourseException(e.getMessage());
		}
		
		
	}

}
