package com.codeclan.example.bookingsystem.controllers;

import com.codeclan.example.bookingsystem.models.Customer;
import com.codeclan.example.bookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "courseId", required = false) Long courseId) {
        if (courseId != null) {
            return new ResponseEntity<List<Customer>>(customerRepository.findCustomerByBookingsCourseId(courseId), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.OK);
        }
    }
}
