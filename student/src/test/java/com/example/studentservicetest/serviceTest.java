package com.example.studentservicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.student.dao.StudentDao;
import com.example.student.studententity.StudentEntity;
import com.example.student.studentservice.StudentServiceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
class serviceTest {
	// @Autowired
	@InjectMocks
	StudentServiceimpl studentServiceimpl;
	@Mock
	private StudentDao studentDao;

	/*
	 * @Autowired private ObjectMapper objectMapper;
	 */
	@BeforeEach
	void setUp() {
		Optional<StudentEntity> student = Optional
				.of(new StudentEntity("17", "ashu", "sangale", "as@gmail.com", 23.44));
		when(studentDao.findById("17")).thenReturn(student);
		when(studentDao.insert("17")).thenReturn(student);

	}

	@Test
	void testAddstudent() {
		StudentEntity student = givenStudent();
		when(studentDao.save(student)).thenReturn(student);
	}

	@Test
	void testGetstudentById() {
		String firstname = "ashu";
		StudentEntity studentById = studentServiceimpl.getstudentById("17");
		assertEquals(firstname, studentById.getFirstname());

	}

	@Test
	void testUpdatedstudentById() {
		StudentEntity student = givenStudentUpdated();
		/*
		 * student.setFirstname("ashsii"); studentDao.save(student);
		 */
		when(studentDao.save(student)).thenReturn(student);
		assertEquals("17", studentServiceimpl.updatedstudentById(student));

	}

	/*
	 * @Test void t estDeletestudentById() { StudentEntity student = new
	 * StudentEntity("17", "ashu", "sangale", "as@gmail.com", 23.44); //
	 * when(student).deleteById(student);
	 * when(studentDao.returnStudent("17")).thenReturn(student);
	 * studentServiceimpl.deletestudentById(student); verify(studentDao,
	 * times("17")).save(student);
	 * 
	 * }
	 */
	@Test
	 void testDeletestudentById() {
	StudentEntity student = givenStudent();
	 doNothing().when(student).deleteById(student);
	verify(studentDao, time("17")).save(student);


	 

	    }

	public StudentEntity givenStudent() {
		StudentEntity student = new StudentEntity();
		student.setId("17");
		student.setFirstname("ashu");
		student.setLastname("sangale");
		student.setEmail("as@gmail.com");
		student.setMarks(3.44);
		return student;
	}

	public StudentEntity givenStudentUpdated() {
		StudentEntity student = new StudentEntity();
		student.setId("17");
		student.setFirstname("muskan");
		student.setLastname("khan");
		student.setEmail("ms@gmail.com");
		student.setMarks(23.44);
		return student;
	}

	public StudentEntity deletetstudent() {
		StudentEntity student = new StudentEntity();
		student.setId("17");
		student.setFirstname("muskan");
		student.setLastname("khan");
		student.setEmail("ms@gmail.com");
		student.setMarks(23.44);
		return student;
	}
}
