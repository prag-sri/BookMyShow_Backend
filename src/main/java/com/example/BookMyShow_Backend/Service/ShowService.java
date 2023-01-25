package com.example.BookMyShow_Backend.Service;

import com.example.BookMyShow_Backend.Models.*;
import com.example.BookMyShow_Backend.Repositories.MovieRepository;
import com.example.BookMyShow_Backend.Repositories.ShowRepository;
import com.example.BookMyShow_Backend.Repositories.ShowSeatRepository;
import com.example.BookMyShow_Backend.Repositories.TheatreRepository;
import com.example.BookMyShow_Backend.RequestDTO.ShowRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowRequestDTO showRequestDTO)
    {
        ShowEntity show= ShowEntity.builder()
                .showDt(showRequestDTO.getShowDt())
                .showTime(showRequestDTO.getShowTime())
                .multiplier(showRequestDTO.getMultiplier())
                .build();

        MovieEntity movie= movieRepository.findByMovieName(showRequestDTO.getMovieName());

        TheatreEntity theatre= theatreRepository.findById(showRequestDTO.getTheatreId()).get();

        show.setMovie(movie);
        show.setTheatre(theatre);

        movie.getShows().add(show);
        theatre.getListOfShows().add(show);

        List<ShowSeatEntity> showSeatEntityList= createShowSeats(theatre.getTheatreSeatsList());
        for(ShowSeatEntity showSeat: showSeatEntityList)
        {
            showSeat.setShow(show);
        }
        show.setShowSeats(showSeatEntityList);

        //showRepository.save(show);

        movieRepository.save(movie);

        return "Show Added Successfully!";
    }

    public List<ShowSeatEntity> createShowSeats(List<TheatreSeatEntity> theatreSeatEntityList)
    {
        List<ShowSeatEntity> seats= new ArrayList<>();
        for(TheatreSeatEntity theatreSeat: theatreSeatEntityList)
        {
            ShowSeatEntity showSeat= ShowSeatEntity.builder()
                                        .seatNo(theatreSeat.getSeatNo())
                                        .seatType(theatreSeat.getSeatType()).build();
            seats.add(showSeat);
        }
        showSeatRepository.saveAll(seats);
        return seats;
    }
}
