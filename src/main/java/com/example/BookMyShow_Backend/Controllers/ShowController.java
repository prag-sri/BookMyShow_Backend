package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.DTOs.ShowRequestDTO;
import com.example.BookMyShow_Backend.DTOs.TheatreResponseDTO2;
import com.example.BookMyShow_Backend.Service.Implementation.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowServiceImpl showServiceImpl;

    @PostMapping("/add_show")
    public String addShow(@RequestBody ShowRequestDTO showRequestDTO)
    {
        return showServiceImpl.addShow(showRequestDTO);
    }

//    @GetMapping("/get_shows_between_given_time")
//    public List<ShowResponseDTO> getShowsBetweenGivenTime(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date)
//    {
//        return showService.getShowsBetweenGivenTime(showDt,startTime,endTime);
//    }

    @GetMapping("/get_theatres_of_movie_shows")
    public List<TheatreResponseDTO2> getTheatresOfMovieShows(@RequestParam("movieName")String movieName){
        return showServiceImpl.getTheatresOfMovieShows(movieName);
    }
}
