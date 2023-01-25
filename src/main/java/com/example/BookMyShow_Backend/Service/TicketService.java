package com.example.BookMyShow_Backend.Service;

import com.example.BookMyShow_Backend.Models.*;
import com.example.BookMyShow_Backend.Repositories.ShowRepository;
import com.example.BookMyShow_Backend.Repositories.TicketRepository;
import com.example.BookMyShow_Backend.Repositories.UserRepository;
import com.example.BookMyShow_Backend.RequestDTO.BookTicketRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    public String bookTicket(BookTicketRequestDTO bookTicketRequestDTO) throws Exception
    {
        List<String> requestSeats= bookTicketRequestDTO.getRequestSeats();
        int showId= bookTicketRequestDTO.getShowId();
        ShowEntity show= showRepository.findById(showId).get();

        int userId= bookTicketRequestDTO.getUserId();
        UserEntity user= userRepository.findById(userId).get();

        List<ShowSeatEntity> showSeats= show.getShowSeats();

        List<ShowSeatEntity> bookedSeats= new ArrayList<>();

        for(ShowSeatEntity showSeat: showSeats)
        {
            String seatNo= showSeat.getSeatNo();
            if(showSeat.isBooked()==false && requestSeats.contains(seatNo))
            {
                bookedSeats.add(showSeat);
            }
        }

        if(requestSeats.size()!=bookedSeats.size())
            throw new Exception("Requested Seats are not available!");

        TicketEntity ticket= new TicketEntity();

        double totalAmount=0;
        int rate=0;

        TheatreEntity theatre= show.getTheatre();
        double multiplier= show.getMultiplier();

        String allotedSeats="";

        for(ShowSeatEntity showSeat: bookedSeats)
        {
            showSeat.setBooked(true);
            showSeat.setBookedAt(new Date());
            showSeat.setShow(show);
            showSeat.setTicket(ticket);

            allotedSeats+= showSeat.getSeatNo()+",";

            if(showSeat.getSeatNo().charAt(0)=='1')
                rate= 100;
            else
                rate=200;
            totalAmount= totalAmount+ multiplier * rate;
        }

        ticket.setBookedOn(new Date());
        ticket.setAmount((int) totalAmount);
        ticket.setShow(show);
        ticket.setUser(user);
        ticket.setShowSeats(bookedSeats);
        ticket.setAlloted_seats(allotedSeats);

        ticketRepository.save(ticket);

        return "Ticket booked successfully!";
    }
}
