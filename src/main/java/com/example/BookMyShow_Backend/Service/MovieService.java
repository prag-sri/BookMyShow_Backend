package com.example.BookMyShow_Backend.Service;

import com.example.BookMyShow_Backend.DTOs.MovieRequestDTO;
import com.example.BookMyShow_Backend.Models.MovieEntity;
import com.example.BookMyShow_Backend.Models.ShowEntity;
import com.example.BookMyShow_Backend.Models.TheatreEntity;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    public String addMovie(MovieRequestDTO movieRequestDTO);
    public MovieEntity findByName(String name);
    public List<ShowEntity> getAllShows(Integer movieId, LocalDate fromDt, LocalDate toDt);
    public List<TheatreEntity> getAllTheatres(Integer id);
}
