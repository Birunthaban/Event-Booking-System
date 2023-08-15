package com.birunthaban.controller;

import com.birunthaban.model.Hall;
import com.birunthaban.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Hall>> getAllHalls (){

        List<Hall> halls = hallService.findAllHalls();
        return new ResponseEntity<List<Hall>> (halls,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Hall getHallById(@PathVariable Integer id) {
        return hallService.getHallById(id);
    }
}
