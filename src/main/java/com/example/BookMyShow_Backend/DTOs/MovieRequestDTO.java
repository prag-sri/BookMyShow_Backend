package com.example.BookMyShow_Backend.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class MovieRequestDTO {

    private String movieName;
    private Date releaseDt;
    private int duration;
}
