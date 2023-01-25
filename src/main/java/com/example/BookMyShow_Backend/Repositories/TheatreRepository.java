package com.example.BookMyShow_Backend.Repositories;

import com.example.BookMyShow_Backend.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity,Integer> {

    TheatreEntity findByNameAndCity(String name, String city);
}
