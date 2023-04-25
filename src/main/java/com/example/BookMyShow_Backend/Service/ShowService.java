package com.example.BookMyShow_Backend.Service;

import com.example.BookMyShow_Backend.DTOs.ShowRequestDTO;
import com.example.BookMyShow_Backend.DTOs.TheatreResponseDTO2;
import com.example.BookMyShow_Backend.Models.ShowSeatEntity;
import com.example.BookMyShow_Backend.Models.TheatreSeatEntity;

import java.util.List;

public interface ShowService {

    public String addShow(ShowRequestDTO showRequestDTO);
    public List<ShowSeatEntity> createShowSeats(List<TheatreSeatEntity> theatreSeatEntityList);
    public List<TheatreResponseDTO2> getTheatresOfMovieShows(String movieName);
}
