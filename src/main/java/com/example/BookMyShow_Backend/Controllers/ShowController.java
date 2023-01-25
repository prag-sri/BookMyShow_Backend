package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.RequestDTO.ShowRequestDTO;
import com.example.BookMyShow_Backend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add_show")
    public String addShow(@RequestBody ShowRequestDTO showRequestDTO)
    {
        return showService.addShow(showRequestDTO);
    }
}
