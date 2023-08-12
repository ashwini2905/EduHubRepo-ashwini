package com.atos.eduhub.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "course")
public class CourseModel {
	@Id
	private String courseID;
	@Indexed(unique= true)
	@NotNull(message = "Name is mandtory")
	@NotEmpty(message = "Name Should not be an empty")
	@NotBlank(message = "Name Should not be blank")
	private String courseName;

	@NotNull(message = "Description is mandtory")
	@NotEmpty(message = "Description Should not be an empty")
	@NotBlank(message = "Description Should not be blank")
	private String courseDescription;

	@NotNull(message = "Skills are mandtory")
	@NotEmpty(message = "Skills Should not be an empty")
	@NotBlank(message = "Skills Should not be blank")
	private String skillRequired;

	@CreatedDate
	private Date createdOn;

	@LastModifiedDate
	private Date lastUpdatedOn;

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getSkillRequired() {
		return skillRequired;
	}

	public void setSkillRequired(String skillRequired) {
		this.skillRequired = skillRequired;
	}

	public Date getCreatedOn() {
		return createdOn;// new Date();
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;// new Date();
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

}
