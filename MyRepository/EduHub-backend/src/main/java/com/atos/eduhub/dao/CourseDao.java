package com.atos.eduhub.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.atos.eduhub.model.CourseModel;

@Repository
public interface CourseDao extends MongoRepository<CourseModel, String> {

}