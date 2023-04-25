package com.example.BookMyShow_Backend.Service.Implementation;

import com.example.BookMyShow_Backend.DTOs.TicketResponseDTO;
import com.example.BookMyShow_Backend.Models.*;
import com.example.BookMyShow_Backend.Repositories.ShowRepository;
import com.example.BookMyShow_Backend.Repositories.TicketRepository;
import com.example.BookMyShow_Backend.Repositories.UserRepository;
import com.example.BookMyShow_Backend.DTOs.BookTicketRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl {

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

    public String cancelTicket(int id) throws Exception
    {
        TicketEntity ticket= ticketRepository.findById(id).get();
        if(ticket==null)
            throw new Exception("Invalid Ticket Id!");

        double amount= ticket.getAmount();
        amount= amount-(0.2*amount);
        String result= "Rs. "+amount+" refunded!";

        List<ShowSeatEntity> showSeats= ticket.getShowSeats();
        for(ShowSeatEntity showSeat: showSeats)
        {
            showSeat.setBooked(false);
            showSeat.setBookedAt(null);
            showSeat.setTicket(null);
        }
        ticketRepository.delete(ticket);

        return result;
    }

    public List<TicketResponseDTO> viewBookedTickets(Integer userId){
        List<TicketResponseDTO> ticketResponseDTOList= new ArrayList<>();

        UserEntity user= userRepository.findById(userId).get();

        List<TicketEntity> ticketEntityList= ticketRepository.findAll();
        for(TicketEntity ticket: ticketEntityList)
        {
            UserEntity userEntity= ticket.getUser();
            if(userEntity.getId()==userId)
            {
//                TicketResponseDTO ticketResponseDTO= TicketResponseDTO.builder().
//                        id(ticket.getId()).
//                        alloted_seats(ticket.getAlloted_seats()).
//                        amount(ticket.getAmount()).
//                        bookedOn(ticket.getBookedOn()).
//                        movieName(ticket.getShow().getMovie().getMovieName()).
//                        theatreName(ticket.getShow().getTheatre().getName()).
//                        showDt(ticket.getShow().getShowDt()).
//                        showTime(ticket.getShow().getShowTime()).build();
                TicketResponseDTO ticketResponseDTO= new TicketResponseDTO(ticket);
                ticketResponseDTOList.add(ticketResponseDTO);
            }
        }
        return ticketResponseDTOList;
    }
}
