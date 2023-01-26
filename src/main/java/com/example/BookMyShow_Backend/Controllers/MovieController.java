package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.Models.MovieEntity;
import com.example.BookMyShow_Backend.Models.ShowEntity;
import com.example.BookMyShow_Backend.Models.TheatreEntity;
import com.example.BookMyShow_Backend.RequestDTO.MovieRequestDTO;
import com.example.BookMyShow_Backend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public String addMovie(@RequestBody MovieRequestDTO movieRequestDTO)
    {
        return movieService.addMovie(movieRequestDTO);
    }

    @GetMapping("/find_movie_by_name")
    public MovieEntity findByName(@RequestParam("name") String name)
    {
        return movieService.findByName(name);
    }

    @GetMapping("/find_all_shows")
    public List<ShowEntity> getAllShows(@RequestParam("id") Integer id, @RequestParam("fromDt") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDt, @RequestParam("toDt") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDt)
    {
        return movieService.getAllShows(id,fromDt,toDt);
    }

    @GetMapping("/find_all_theatres")
    public List<TheatreEntity> getAllTheatres(@RequestParam("id") Integer id)
    {
        return movieService.getAllTheatres(id);
    }

}
