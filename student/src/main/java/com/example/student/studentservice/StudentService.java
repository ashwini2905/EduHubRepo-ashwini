package com.example.student.studentservice;

import com.example.student.studententity.StudentEntity;

public interface StudentService {
	public StudentEntity addstudent(StudentEntity student);

	StudentEntity getstudentById(String id);

	StudentEntity updatedstudentById(StudentEntity updatestudent);
	void deletestudentById(String id);
}
