package com.example.BookMyShow_Backend.RequestDTO;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequestDTO {

    private List<String> requestSeats;
    private int showId;
    private int userId;

}
