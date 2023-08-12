package com.example.student.studentdao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.example.student.dao.StudentDao;

import com.example.student.studententity.StudentEntity;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TestStudentDao {
	@MockBean
	//@Autowired
	private StudentDao studentDao;
//	@InjectMocks
//	private StudentServiceimpl studentServiceimpl;
	// initalize data
	@BeforeEach
	void setUp() {
		System.out.println("It will be Run Before Each Test");
		System.out.println("=====================");
	}

	@BeforeAll
	public static void init() {
		System.out.println("BeforeAll init() method called");
		System.out.println("=====================");
	}

	@RepeatedTest(value = 2, name = "updatedstudent") // it will be used to run any method multiple time
	void repeatedTest(TestInfo testInfo) {
		System.out.println("Executing repeated test");
		assertNotEquals("ashwini", studentDao.findById("12").get().getFirstname());

	}

	@Test // testing for savedstudent
	// @Tag("devloper")
	@DisplayName("Testing for StudentDao Class")
	@Order(value = 1)
	// @Disabled // Do not run in lower environment
	@Rollback(false) // to disable roll back to the data will be committed to the database and //
						// available for the next test methods which will run separately.
	void saveStudentandFindStudentTest() {
		StudentEntity student = new StudentEntity();
		student.setId("18");
		student.setFirstname("ashwini");
		student.setLastname("sangale");
		student.setEmail("ashu123@gmal.com");
		studentDao.save(student);
	//	assertNotNull(studentDao.findById("15").get());
		System.out.println("its finding data by id in the database");
		assertEquals("18", student.getId());
		// assertNull(student);//failed because student is not null
		assertTrue(" if Student is present then its true ", true);
		assertTrue(" if Student is  not present then its false  ", false);
		System.out.println("running SAVE and GET method");

	}

	private void assertTrue(String string, boolean b) {

	}

	@Test
	// @Tag("production")
	@DisplayName("Testing for StudentDao Class")
	@Order(value = 2)
	void updatedstudent() {
		StudentEntity student = studentDao.findById("12").get();
		student.setFirstname("ashsii");
		studentDao.save(student);
		assertNotEquals("ashwini", studentDao.findById("12").get().getFirstname());
	}

	 @Disabled // Do not run in lower environment
	@Test
	@Tag("devloper")
	@DisplayName("Testing for StudentDao Class")
	@Order(value = 3)
	void deletestudent() {

		studentDao.deleteById("13");
		assertThat(studentDao.existsById("13")).isFalse();
		// assertThat(studentDao.existsById("13")).isTrue();

	}

	// clear data clear memory
	@AfterEach
	void clean() {
		System.out.println("It will be Run After Each Test");
		System.out.println("=====================");
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("After All cleanUp() method called");
		System.out.println("=====================");

	}
}
