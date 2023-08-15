package com.birunthaban.service;

import com.birunthaban.model.Hall;
import com.birunthaban.model.Hotel;
import com.birunthaban.repository.HallRepository;
import com.birunthaban.repository.HotelRepository;
import com.birunthaban.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HallService {
    @Autowired
    UserRepository userRepository ;
    @Autowired
    HallRepository hallRepository ;
    @Autowired
    HotelRepository hotelRepository ;
    public void createHall(Hall hall, Integer hotelId)  {
        // Retrieve the hotel from the database using the hotelId
            Hotel hotel = hotelRepository.findById(hotelId).orElse(null);

            if (hotel == null) {

                throw new RuntimeException("No Hotel is found");
            }
            hall.setHotel(hotel);


            hallRepository.save(hall);



        }



}
