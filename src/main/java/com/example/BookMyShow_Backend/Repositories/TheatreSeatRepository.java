package com.example.BookMyShow_Backend.Repositories;

import com.example.BookMyShow_Backend.Models.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeatEntity,Integer> {
}
