package com.example.BookMyShow_Backend.DTOs;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreResponseDTO2 {
    private int id;
    private String name;
    private String city;
    private String address;
    private LocalDate showDt;
    private LocalTime showTime;
}
