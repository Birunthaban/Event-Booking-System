package com.birunthaban.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@AllArgsConstructor
@Entity
@Data
@Builder
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    // You can add more attributes as needed
    @ManyToOne
    private User user ;
    @ManyToOne
    private Hall hall; // Many bookings belong to one hall
}
