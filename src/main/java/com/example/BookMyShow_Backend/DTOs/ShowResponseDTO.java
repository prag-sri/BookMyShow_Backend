package com.example.BookMyShow_Backend.DTOs;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowResponseDTO {

    private String movieName;
    private LocalDate showDt;
    private LocalTime showTime;
    private String theatreName;
}
