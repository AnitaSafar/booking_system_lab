package com.codeclan.example.bookingsystem;

import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookingsystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void canFindCoursesByRating() {
	List<Course> found = courseRepository.findCourseByRating(4);
	assertEquals(1, found.size());
	}
}
