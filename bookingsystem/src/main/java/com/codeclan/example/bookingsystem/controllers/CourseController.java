package com.codeclan.example.bookingsystem.controllers;

import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "customer", required = false) String name
    ) {
        if (rating != null) {
            return new ResponseEntity<List<Course>>(courseRepository.findCourseByRating(rating), HttpStatus.OK);
        } else if (name != null) {
            return new ResponseEntity<List<Course>>(courseRepository.findCourseByBookingsCustomerNameIgnoreCase(name), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<List<Course>>(courseRepository.findAll(), HttpStatus.OK);
        }
    }
}
