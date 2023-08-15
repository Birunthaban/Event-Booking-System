package com.birunthaban.service;

import com.birunthaban.model.Booking;
import com.birunthaban.model.Hall;
import com.birunthaban.model.User;
import com.birunthaban.repository.BookingRepository;
import com.birunthaban.repository.HallRepository;
import com.birunthaban.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    HallRepository hallRepository;
    @Autowired
    UserRepository userRepository;
    public boolean isHallAvailable(Hall hall, LocalDateTime startTime, LocalDateTime endTime ) {

        List<Booking> conflictingBookings = bookingRepository.findConflictingBookings(hall, startTime, endTime);

        return conflictingBookings.isEmpty();
    }
    public void bookHall(Integer hallId, LocalDateTime startTime, LocalDateTime endTime , Integer userId){
        Hall hall =hallRepository.findById(hallId).orElse(null);
        User user =userRepository.findById(userId).orElse(null);
        if (hall != null && user!= null){
            if(isHallAvailable(hall , startTime, endTime)){

                Booking booking = Booking.builder().hall(hall).startTime(startTime).endTime(endTime).build();
                bookingRepository.save(booking);


            }
            else{
                throw new RuntimeException("Time Slot not available");

            }

        }
        else{
            throw new RuntimeException("Hall/User Not Found Exception");
        }

    }
}
