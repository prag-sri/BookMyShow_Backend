package com.example.BookMyShow_Backend.Repositories;

import com.example.BookMyShow_Backend.DTOs.TheatreRequestDTO;
import com.example.BookMyShow_Backend.DTOs.TheatreResponseDTO;
import com.example.BookMyShow_Backend.Models.TheatreEntity;
import com.example.BookMyShow_Backend.Models.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity,Integer> {

    public Optional<TheatreEntity> findById(Integer id);
}
