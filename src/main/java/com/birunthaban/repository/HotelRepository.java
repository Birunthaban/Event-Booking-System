package com.birunthaban.repository;

import com.birunthaban.model.Hotel;
import com.birunthaban.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {


}
