package com.codeclan.example.bookingsystem;

import com.codeclan.example.bookingsystem.controllers.CustomerController;
import com.codeclan.example.bookingsystem.models.Booking;
import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.models.Customer;
import com.codeclan.example.bookingsystem.repositories.BookingRepository;
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

	@Autowired
	BookingRepository bookingRepository;

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
		List<Course> found = courseRepository.findCourseByBookingsCustomerNameIgnoreCase("Bob");
		assertEquals(1, found.size());
	}

	@Test
	public void canFindBookingByDate() {
		List<Booking> found = bookingRepository.findBookingByDate("30/10/22");
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByBookingsCourseTown() {
		List<Customer> found = customerRepository.findCustomerByTownIgnoreCaseAndBookingsCourseId("Edinburgh", 1L);
		assertEquals(1, found.size());
	}

	@Test
	public void canFindCustomerByTownAndAgeAndCourseId() {
		List<Customer> found = customerRepository.findCustomerByTownIgnoreCaseAndAgeGreaterThanAndBookingsCourseId("edinburgh", 18, 1L);
		assertEquals(1, found.size());
	}
}
