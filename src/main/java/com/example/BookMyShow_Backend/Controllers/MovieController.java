package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.Models.MovieEntity;
import com.example.BookMyShow_Backend.Models.ShowEntity;
import com.example.BookMyShow_Backend.Models.TheatreEntity;
import com.example.BookMyShow_Backend.DTOs.MovieRequestDTO;
import com.example.BookMyShow_Backend.Service.Implementation.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieServiceImpl movieServiceImpl;

    @PostMapping("/addMovie")
    public String addMovie(@RequestBody MovieRequestDTO movieRequestDTO)
    {
        return movieServiceImpl.addMovie(movieRequestDTO);
    }

    @GetMapping("/find_movie_by_name")
    public MovieEntity findByName(@RequestParam("name") String name)
    {
        return movieServiceImpl.findByName(name);
    }

    @GetMapping("/find_all_shows")
    public List<ShowEntity> getAllShows(@RequestParam("id") Integer id, @RequestParam("fromDt") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDt, @RequestParam("toDt") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDt)
    {
        return movieServiceImpl.getAllShows(id,fromDt,toDt);
    }

    @GetMapping("/get_all_theatres")
    public List<TheatreEntity> getAllTheatres(@RequestParam("id") Integer id)
    {
        return movieServiceImpl.getAllTheatres(id);
    }

}
