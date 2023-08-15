package com.birunthaban.repository;

import com.birunthaban.model.Hotel;
import com.birunthaban.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByNameContainingIgnoreCase(String substring);
    List<Hotel> findFirst10ByOrderByCreatedAtDesc();

}
