package com.codeclan.example.bookingsystem;

import com.codeclan.example.bookingsystem.controllers.CustomerController;
import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.models.Customer;
import com.codeclan.example.bookingsystem.repositories.CourseRepository;
import com.codeclan.example.bookingsystem.repositories.CustomerRepository;
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

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void canFindCoursesByRating() {
	List<Course> found = courseRepository.findCourseByRating(4);
	assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByCourse() {
		List<Customer> found = customerRepository.findCustomerByBookingsCourseId(1L);
		assertEquals(2, found.size());
	}

	@Test
	public void canFindCourseByCustomer() {
		List<Course> found = courseRepository.findCourseByBookingsCustomerName("Bob");
		assertEquals(1, found.size());
	}
}
