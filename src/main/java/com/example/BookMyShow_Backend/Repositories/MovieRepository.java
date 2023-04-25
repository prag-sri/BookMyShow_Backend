package com.example.BookMyShow_Backend.Repositories;

import com.example.BookMyShow_Backend.DTOs.MovieRequestDTO;
import com.example.BookMyShow_Backend.Models.MovieEntity;
import com.example.BookMyShow_Backend.Models.ShowEntity;
import com.example.BookMyShow_Backend.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    public MovieEntity findByMovieName(String movieName);
}
