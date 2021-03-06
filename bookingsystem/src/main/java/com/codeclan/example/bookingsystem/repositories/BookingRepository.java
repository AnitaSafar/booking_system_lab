package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByDate(String date);
}
