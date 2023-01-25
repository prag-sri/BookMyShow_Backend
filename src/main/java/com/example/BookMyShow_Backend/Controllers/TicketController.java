package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.RequestDTO.BookTicketRequestDTO;
import com.example.BookMyShow_Backend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO)
    {
        try
        {
            return ticketService.bookTicket(bookTicketRequestDTO);
        }catch(Exception e){
            return "Requested seats not available!";
        }
    }
}
