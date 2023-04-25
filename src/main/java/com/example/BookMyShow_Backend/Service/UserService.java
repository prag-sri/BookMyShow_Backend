package com.example.BookMyShow_Backend.Service;

import com.example.BookMyShow_Backend.DTOs.TicketResponseDTO;
import com.example.BookMyShow_Backend.DTOs.UserRequestDTO;
import com.example.BookMyShow_Backend.Models.UserEntity;

import java.util.List;

public interface UserService {

    public String addUser(UserRequestDTO userRequestDTO);
    public UserEntity findByName(String name);
    public List<UserEntity> findAll();
    public List<TicketResponseDTO> getAllTickets(Integer id);
}
