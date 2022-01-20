package com.codeclan.example.bookingsystem.models;

import java.util.ArrayList;

public class Course {
    private Long id;
    private String name;
    private String town;
    private Rating rating;
    private ArrayList<Booking> bookings;

    public Course(String name, String town, Rating rating, ArrayList<Booking> bookings) {
        this.name = name;
        this.town = town;
        this.rating = rating;
        this.bookings = bookings;
    }

    public Course() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
