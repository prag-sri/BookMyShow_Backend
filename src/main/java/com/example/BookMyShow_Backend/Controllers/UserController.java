package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.Models.UserEntity;
import com.example.BookMyShow_Backend.DTOs.TicketResponseDTO;
import com.example.BookMyShow_Backend.DTOs.UserRequestDTO;
import com.example.BookMyShow_Backend.Service.Implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/add_user")
    public String addUser(@RequestBody UserRequestDTO userRequestDTO)
    {
        String result= userServiceImpl.addUser(userRequestDTO);
        return result;
    }

    @GetMapping("/find_user_by_name")
    public UserEntity findByName(@RequestParam("name") String name)
    {
        return userServiceImpl.findByName(name);
    }

    @GetMapping("/find_all_users")
    public List<UserEntity> findAll()
    {
        return userServiceImpl.findAll();
    }

    @GetMapping("/get_tickets")
    public List<TicketResponseDTO> getAllTickets(@RequestParam("id") Integer id)
    {
        return userServiceImpl.getAllTickets(id);
    }
}
