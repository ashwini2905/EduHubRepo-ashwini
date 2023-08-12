package com.example.student.dao;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.student.studententity.StudentEntity;

public interface StudentDao extends MongoRepository<StudentEntity, String> {

	Optional<StudentEntity> findById(String id);

	

	//void save();

	
	

	

	//void saveStudentTest(String string);


	
	


	



	

	

	
	
	

}