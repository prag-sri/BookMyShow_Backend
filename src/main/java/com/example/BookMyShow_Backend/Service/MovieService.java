package com.example.BookMyShow_Backend.Service;

import com.example.BookMyShow_Backend.Models.MovieEntity;
import com.example.BookMyShow_Backend.Repositories.MovieRepository;
import com.example.BookMyShow_Backend.RequestDTO.MovieRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

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
}
