package com.example.BookMyShow_Backend.Repositories;

import com.example.BookMyShow_Backend.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
