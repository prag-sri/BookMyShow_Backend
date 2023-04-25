package com.example.BookMyShow_Backend.Repositories;

import com.example.BookMyShow_Backend.DTOs.BookTicketRequestDTO;
import com.example.BookMyShow_Backend.DTOs.TicketResponseDTO;
import com.example.BookMyShow_Backend.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {

}
