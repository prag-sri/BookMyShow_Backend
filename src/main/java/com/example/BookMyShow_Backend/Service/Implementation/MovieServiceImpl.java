package com.example.BookMyShow_Backend.Service.Implementation;

import com.example.BookMyShow_Backend.Models.MovieEntity;
import com.example.BookMyShow_Backend.Models.ShowEntity;
import com.example.BookMyShow_Backend.Models.TheatreEntity;
import com.example.BookMyShow_Backend.Repositories.MovieRepository;
import com.example.BookMyShow_Backend.DTOs.MovieRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequestDTO movieRequestDTO)
    {
        MovieEntity movie= MovieEntity.builder()
                .movieName(movieRequestDTO.getMovieName())
                .releaseDt(movieRequestDTO.getReleaseDt())
                .duration(movieRequestDTO.getDuration()).build();
        try {
            movieRepository.save(movie);
        }catch(Exception e){
            return "Could not add movie!";
        }
        return "Movie added successfully!";
    }

    public MovieEntity findByName(String name)
    {
        for(MovieEntity movie: movieRepository.findAll())
        {
            if(movie.getMovieName().equals(name))
                return movie;
        }
        return null;
    }

    public List<ShowEntity> getAllShows(Integer movieId, LocalDate fromDt, LocalDate toDt)
    {
        List<ShowEntity> resultShowList= new ArrayList<>();
        MovieEntity movie= movieRepository.findById(movieId).get();
        List<ShowEntity> showList= movie.getShows();
        for(ShowEntity show: showList)
        {
            LocalDate showDt= show.getShowDt();
            if(fromDt.isEqual(showDt))
                resultShowList.add(show);
            else if(toDt.isEqual(showDt))
                resultShowList.add(show);
            else if(fromDt.isBefore(showDt) && toDt.isAfter(showDt))
                resultShowList.add(show);
        }
        return resultShowList;
    }

    public List<TheatreEntity> getAllTheatres(Integer id)
    {
        MovieEntity movie= movieRepository.findById(id).get();

        List<TheatreEntity> theatreList= new ArrayList<>();

        List<ShowEntity> showsList= movie.getShows();
        for(ShowEntity show: showsList)
        {
            TheatreEntity theatre= show.getTheatre();
            if(theatreList.size()==0 || !theatreList.contains(theatre))
                theatreList.add(theatre);
        }

        return theatreList;
    }
}
