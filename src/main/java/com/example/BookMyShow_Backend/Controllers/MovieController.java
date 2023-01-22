package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.Models.MovieEntity;
import com.example.BookMyShow_Backend.RequestDTO.MovieRequestDTO;
import com.example.BookMyShow_Backend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("find_movie_by_name")
    public MovieEntity findByName(@RequestParam("name") String name)
    {
        return movieService.findByName(name);
    }

}
