package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.RequestDTO.ShowRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @PostMapping("/add_show")
    public String addShow(@RequestBody ShowRequestDTO showRequestDTO)
    {

    }
}
