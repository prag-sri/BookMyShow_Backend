package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.DTOs.TheatreRequestDTO;
import com.example.BookMyShow_Backend.DTOs.TheatreResponseDTO;
import com.example.BookMyShow_Backend.Service.Implementation.TheatreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreServiceImpl theatreServiceImpl;

    @PostMapping("/add_theatre")
    public String addTheatre(@RequestBody TheatreRequestDTO theatreRequestDTO){
        return theatreServiceImpl.addTheatre(theatreRequestDTO);
    }

    @GetMapping("/findById/{id}")
    public TheatreResponseDTO findById(@PathVariable("id")Integer id){
        return theatreServiceImpl.findById(id);
    }

    @GetMapping("/get_all")
    public List<TheatreResponseDTO> getTheatresList(){
        return theatreServiceImpl.getTheatresList();
    }
}
