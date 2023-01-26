package com.example.BookMyShow_Backend.RequestDTO;

import com.example.BookMyShow_Backend.Models.TicketEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class TicketResponseDTO {

    private int id;
    private String alloted_seats;
    private int amount;
    private Date bookedOn;
    private String movieName;
    private String theatreName;
    private LocalDate showDt;
    private LocalTime showTime;

    public TicketResponseDTO(TicketEntity ticket)
    {
        this.id= ticket.getId();
        this.alloted_seats= ticket.getAlloted_seats();
        this.amount= ticket.getAmount();
        this.bookedOn= ticket.getBookedOn();
        this.movieName= ticket.getShow().getMovie().getMovieName();
        this.theatreName= ticket.getShow().getTheatre().getName();
        this.showDt= ticket.getShow().getShowDt();
        this.showTime= ticket.getShow().getShowTime();
    }
}
