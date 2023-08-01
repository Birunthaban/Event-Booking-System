package com.birunthaban.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
    public class Hotel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long hotelId;
        private String name;
        private String address;
        @OneToOne //hotel to user (owner)
        @JoinColumn(name = "owner_id")
        private User owner;


    }


