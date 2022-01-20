package com.codeclan.example.bookingsystem.controllers;

import com.codeclan.example.bookingsystem.models.Booking;
import com.codeclan.example.bookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> canGetAllBookings(
            @RequestParam(name = "date", required = false) String date
    ) {
        if (date != null) {
            return new ResponseEntity<List<Booking>>(bookingRepository.findBookingByDate(date), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Booking>>(bookingRepository.findAll(), HttpStatus.OK);
        }
    }
}
