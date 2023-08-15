package com.birunthaban.repository;

import com.birunthaban.model.Booking;
import com.birunthaban.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.hall = :hall " +
            "AND ((b.startTime >= :startTime AND b.startTime < :endTime) " +
            "OR (b.endTime > :startTime AND b.endTime <= :endTime))")
    List<Booking> findConflictingBookings(@Param("hall") Hall hall,
                                          @Param("startTime") LocalDateTime startTime,
                                          @Param("endTime") LocalDateTime endTime);
}