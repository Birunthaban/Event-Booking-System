package com.birunthaban.controller;

import com.birunthaban.model.Hotel;
import com.birunthaban.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelController {
    @Autowired
    private HotelService hotelservice;
    @PostMapping("/register")
    public ResponseEntity<Void> registerHotel(@RequestBody Hotel hotel){
        hotelservice.registerHotel(hotel);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
