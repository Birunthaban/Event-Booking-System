package com.birunthaban.controller;

import com.birunthaban.model.Hotel;
import com.birunthaban.model.User;
import com.birunthaban.repository.HotelRepository;
import com.birunthaban.repository.UserRepository;
import com.birunthaban.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelController {
    @Autowired
    private HotelService hotelservice;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private UserRepository userRepository ;
    @PostMapping("/register")
    public ResponseEntity<Void> registerHotel(@RequestBody Hotel hotel){

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserEmail = authentication.getName();
            Optional<User> user = userRepository.findByEmail(currentUserEmail);
            if(user.get().getId()== null){
                hotelservice.registerHotel(hotel);
                return new ResponseEntity<>(HttpStatus.OK);

            }else{
                throw new RuntimeException("user name already exists.....");
            }

        }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Integer hotelID){
        hotelRepository.deleteById(hotelID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //get all

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels (){
        List<Hotel> hotels = hotelRepository.findAll();
        return new ResponseEntity<List<Hotel>>(hotels,HttpStatus.OK);
    }
    
    // search - name related
    // top 10



    }


