package com.example.BookMyShow_Backend.DTOs;

import com.example.BookMyShow_Backend.Models.ShowEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreResponseDTO {

    private int id;
    private String name;
    private String city;
    private String address;
    private List<ShowResponseDTO> listOfShows;
}
