package com.birunthaban.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor //
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallId;
    private String name;
    private int capacity;
    @ManyToOne // hall to hotel
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


}