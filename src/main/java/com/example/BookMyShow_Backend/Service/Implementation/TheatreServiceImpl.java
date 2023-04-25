package com.example.BookMyShow_Backend.Service.Implementation;

import com.example.BookMyShow_Backend.DTOs.ShowResponseDTO;
import com.example.BookMyShow_Backend.DTOs.TheatreResponseDTO;
import com.example.BookMyShow_Backend.Models.MovieEntity;
import com.example.BookMyShow_Backend.Models.ShowEntity;
import com.example.BookMyShow_Backend.Models.TheatreEntity;
import com.example.BookMyShow_Backend.Models.TheatreSeatEntity;
import com.example.BookMyShow_Backend.Repositories.MovieRepository;
import com.example.BookMyShow_Backend.Repositories.TheatreRepository;
import com.example.BookMyShow_Backend.Repositories.TheatreSeatRepository;
import com.example.BookMyShow_Backend.DTOs.TheatreRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.BookMyShow_Backend.Enums.SeatType.CLASSIC;
import static com.example.BookMyShow_Backend.Enums.SeatType.PLATINUM;

@Service
public class TheatreServiceImpl {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    @Autowired
    MovieRepository movieRepository;

    public String addTheatre(TheatreRequestDTO theatreRequestDTO)
    {
        TheatreEntity theatreEntity= TheatreEntity.builder()
                .name(theatreRequestDTO.getName())
                .city(theatreRequestDTO.getCity())
                .address(theatreRequestDTO.getAddress()).build();

        List<TheatreSeatEntity> theatreSeatEntityList= createTheatreSeats();

        theatreEntity.setTheatreSeatsList(theatreSeatEntityList);

        for(TheatreSeatEntity theatreSeatEntity: theatreSeatEntityList)
        {
            theatreSeatEntity.setTheatre(theatreEntity);
        }

        try
        {
            theatreRepository.save(theatreEntity);      //theatreSeatEntity is also getting saved here as list associated with theatre is getting saved with theatreSeatEntity
        }catch(Exception e) {
            return "Could not save Theatre!";
        }

        return "Theatre added successfully!";
    }

    public List<TheatreSeatEntity> createTheatreSeats(){
        List<TheatreSeatEntity> seatEntityList= new ArrayList<>();
        for(int i=1; i<=5; i++)
        {
            String seatNo= "1"+(char)('A'+i-1);
            TheatreSeatEntity theatreSeat1= new TheatreSeatEntity(seatNo,CLASSIC,100);
            seatEntityList.add(theatreSeat1);
            seatNo= "2"+(char)('A'+i-1);
            TheatreSeatEntity theatreSeat2= new TheatreSeatEntity(seatNo,PLATINUM,200);
            seatEntityList.add(theatreSeat2);
        }

        theatreSeatRepository.saveAll(seatEntityList);
        return seatEntityList;
    }

    public TheatreResponseDTO findById(Integer id){
        TheatreEntity theatre= theatreRepository.findById(id).get();

        TheatreResponseDTO theatreResponseDTO= TheatreResponseDTO.builder().
                                                id(theatre.getId()).
                                                name(theatre.getName()).
                                                city(theatre.getCity()).
                                                address(theatre.getAddress()).build();
        List<ShowResponseDTO> showResponseDTOList= new ArrayList<>();

        List<ShowEntity> showsList= theatre.getListOfShows();

        for(ShowEntity show: showsList)
        {
            ShowResponseDTO showResponseDTO= ShowResponseDTO.builder().
                                                showDt(show.getShowDt()).
                                                showTime(show.getShowTime()).build();
            MovieEntity movieEntity= show.getMovie();
            String movieName= movieEntity.getMovieName();
            showResponseDTO.setMovieName(movieName);
            showResponseDTOList.add(showResponseDTO);
            theatreResponseDTO.setListOfShows(showResponseDTOList);
        }
        return theatreResponseDTO;
    }

    public List<TheatreResponseDTO> getTheatresList() {
        List<TheatreResponseDTO> theatreResponseDTOList= new ArrayList<>();

        List<TheatreEntity> theatreEntityList= theatreRepository.findAll();

        for(TheatreEntity theatre: theatreEntityList)
        {
            TheatreResponseDTO theatreResponseDTO= findById(theatre.getId());
            theatreResponseDTOList.add(theatreResponseDTO);
        }
        return theatreResponseDTOList;
    }
}
