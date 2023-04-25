package com.example.BookMyShow_Backend.Service.Implementation;

import com.example.BookMyShow_Backend.DTOs.TheatreResponseDTO2;
import com.example.BookMyShow_Backend.Models.*;
import com.example.BookMyShow_Backend.Repositories.MovieRepository;
import com.example.BookMyShow_Backend.Repositories.ShowRepository;
import com.example.BookMyShow_Backend.Repositories.ShowSeatRepository;
import com.example.BookMyShow_Backend.Repositories.TheatreRepository;
import com.example.BookMyShow_Backend.DTOs.ShowRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl {

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

//    public List<ShowResponseDTO> getShowsBetweenGivenTime(LocalDate showDt, LocalTime startTime, LocalTime endTime)
//    {
//        List<ShowResponseDTO> showResponseDTOList= new ArrayList<>();
//        List<ShowEntity> showList= showRepository.findAll();
//        for(ShowEntity show: showList)
//        {
//            LocalDate dt= show.getShowDt();
//            LocalTime time= show.getShowTime();
//            if(dt.equals(showDt) && startTime.isBefore(time) && endTime.isAfter(time))
//            {
//                ShowResponseDTO showResponseDTO= ShowResponseDTO.builder().
//                        movieName(show.getMovie().getMovieName()).
//                        showDt(dt).
//                        showTime(time).
//                        theatreName(show.getTheatre().getName()).build();
//                showResponseDTOList.add(showResponseDTO);
//            }
//        }
//        return showResponseDTOList;
//    }

    public List<TheatreResponseDTO2> getTheatresOfMovieShows(String movieName){
        List<TheatreResponseDTO2> theatreResponseDTOList= new ArrayList<>();

        List<ShowEntity> showEntities= showRepository.findAll();
        for(ShowEntity show: showEntities)
        {
            MovieEntity movie= show.getMovie();
            String name= movie.getMovieName();
            if(name.equals(movieName))
            {
                TheatreEntity theatre= show.getTheatre();
                TheatreResponseDTO2 theatreResponseDTO2= TheatreResponseDTO2.builder().
                        id(theatre.getId()).
                        name(theatre.getName()).
                        city(theatre.getCity()).
                        address(theatre.getAddress()).
                        showDt(show.getShowDt()).
                        showTime(show.getShowTime()).build();
                theatreResponseDTOList.add(theatreResponseDTO2);
            }
        }
        return theatreResponseDTOList;
    }
}
