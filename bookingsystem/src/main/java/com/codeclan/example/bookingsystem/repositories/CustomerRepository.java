package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByBookingsCourseId(Long id);

    List<Customer> findCustomerByTownIgnoreCaseAndBookingsCourseId(String town, Long id);

    List<Customer> findCustomerByTownIgnoreCaseAndAgeGreaterThanAndBookingsCourseId(String town, int age, Long id);
}
