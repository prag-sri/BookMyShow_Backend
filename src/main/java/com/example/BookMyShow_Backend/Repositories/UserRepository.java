package com.example.BookMyShow_Backend.Repositories;

import com.example.BookMyShow_Backend.DTOs.TicketResponseDTO;
import com.example.BookMyShow_Backend.DTOs.UserRequestDTO;
import com.example.BookMyShow_Backend.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    public List<UserEntity> findAll();
}
