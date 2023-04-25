package com.example.BookMyShow_Backend.Service;

import com.example.BookMyShow_Backend.DTOs.BookTicketRequestDTO;
import com.example.BookMyShow_Backend.DTOs.TicketResponseDTO;

import java.util.List;

public interface TicketService {

    public String bookTicket(BookTicketRequestDTO bookTicketRequestDTO);
    public String cancelTicket(int id);
    public List<TicketResponseDTO> viewBookedTickets(Integer userId);
}
