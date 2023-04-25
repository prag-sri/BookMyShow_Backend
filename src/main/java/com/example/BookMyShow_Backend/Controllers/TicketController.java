package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.DTOs.BookTicketRequestDTO;
import com.example.BookMyShow_Backend.DTOs.TicketResponseDTO;
import com.example.BookMyShow_Backend.Service.Implementation.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketServiceImpl;

    @PostMapping("/book")
    public String bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO)
    {
        try
        {
            return ticketServiceImpl.bookTicket(bookTicketRequestDTO);
        }catch(Exception e){
            return "Requested seats not available!";
        }
    }

    @PutMapping("/cancel")
    public String cancelTicket(@RequestParam("id")int id)
    {
        try
        {
            return ticketServiceImpl.cancelTicket(id);
        }catch(Exception e){
            return "Invalid Ticket Id!";
        }
    }

    @GetMapping("/view_booked_tickets")
    public List<TicketResponseDTO> viewBookedTickets(@RequestParam("id")Integer userId){
        return ticketServiceImpl.viewBookedTickets(userId);
    }
}
