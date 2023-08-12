package com.example.student.studentservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.dao.StudentDao;
import com.example.student.studententity.StudentEntity;

@Service

public class StudentServiceimpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	public StudentEntity addstudent(StudentEntity student) {
		return studentDao.save(student);

	}

	@Override
	public StudentEntity getstudentById(String id) {
		Optional<StudentEntity> student = studentDao.findById(id);
		if (student.isPresent()) {
			System.out.println("student with id:" + id + "  exist");

		}
		return student.get();

	}

	@Override
	public StudentEntity updatedstudentById(StudentEntity updatestudent) {
		return studentDao.save(updatestudent);
	}

	@Override
	public void deletestudentById(String id) {
		StudentEntity studententity = getstudentById(id);
		studentDao.deleteById(studententity.getId());

	}

}