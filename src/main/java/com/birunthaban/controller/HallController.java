package com.birunthaban.controller;

import com.birunthaban.model.Hall;
import com.birunthaban.model.Hotel;
import com.birunthaban.model.User;
import com.birunthaban.repository.UserRepository;
import com.birunthaban.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hall")
@RequiredArgsConstructor
public class HallController {
    @Autowired
    HallService hallService;
    @PostMapping("/register")
    public ResponseEntity<Void> registerHall(@RequestBody Hall hall , @PathVariable Integer hotelId){
        hallService.createHall(hall ,hotelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{hallId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Integer hallID){

        hallService.deleteHall(hallID) ;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels (){
        List<Hall> halls = hallService.findAllHalls();
        return new ResponseEntity<List<Hotel>>(halls,HttpStatus.OK);
    }
}
