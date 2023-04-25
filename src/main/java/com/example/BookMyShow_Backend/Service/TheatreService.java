package com.example.BookMyShow_Backend.Service;

import com.example.BookMyShow_Backend.DTOs.TheatreRequestDTO;
import com.example.BookMyShow_Backend.DTOs.TheatreResponseDTO;
import com.example.BookMyShow_Backend.Models.TheatreSeatEntity;

import java.util.List;

public interface TheatreService {

    public String addTheatre(TheatreRequestDTO theatreRequestDTO);
    public List<TheatreSeatEntity> createTheatreSeats();
    public TheatreResponseDTO findById(Integer id);
    public List<TheatreResponseDTO> getTheatresList();
}
