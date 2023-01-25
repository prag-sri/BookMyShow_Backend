package com.example.BookMyShow_Backend.RequestDTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowRequestDTO {

    private LocalDate showDt;
    private LocalTime showTime;
    private String movieName;
    private int theatreId;
    private double multiplier;
}
