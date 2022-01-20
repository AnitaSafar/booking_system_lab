package com.codeclan.example.bookingsystem.components;

import com.codeclan.example.bookingsystem.models.Booking;
import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.models.Customer;
import com.codeclan.example.bookingsystem.repositories.BookingRepository;
import com.codeclan.example.bookingsystem.repositories.CourseRepository;
import com.codeclan.example.bookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Course one = new Course("One", "Edinburgh", 4);
        courseRepository.save(one);
    
        Course two = new Course("Two", "Glasgow", 2);
        courseRepository.save(two);
        
        Course three = new Course("Three", "London", 5);
        courseRepository.save(three);

        Customer alice = new Customer("Alice", "Dundee", 35);
        customerRepository.save(alice);
        
        Customer bob = new Customer("Bob", "Falkirk", 22);
        customerRepository.save(bob);
        
        Customer claire = new Customer("Claire", "Edinburgh", 45);
        customerRepository.save(claire);
        
        Customer karen = new Customer("Karen", "Livingston", 33);
        customerRepository.save(karen);

        Booking booking1 = new Booking("12/05/22", one, alice);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("15/06/22", two, bob);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("30/10/22", three, karen);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("22/01/22", one, claire);
        bookingRepository.save(booking4);
    }
}
