package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.RequestDTO.TheatreRequestDTO;
import com.example.BookMyShow_Backend.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add_theatre")
    public String addTheatre(@RequestBody TheatreRequestDTO theatreRequestDTO)
    {
        return theatreService.addTheatre(theatreRequestDTO);
    }
}
