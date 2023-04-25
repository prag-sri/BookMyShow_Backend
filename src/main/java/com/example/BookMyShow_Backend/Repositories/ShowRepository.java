package com.example.BookMyShow_Backend.Repositories;

import com.example.BookMyShow_Backend.DTOs.ShowRequestDTO;
import com.example.BookMyShow_Backend.Models.ShowEntity;
import com.example.BookMyShow_Backend.Models.ShowSeatEntity;
import com.example.BookMyShow_Backend.Models.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {

}
