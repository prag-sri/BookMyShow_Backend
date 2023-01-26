package com.example.BookMyShow_Backend.Controllers;

import com.example.BookMyShow_Backend.Models.TicketEntity;
import com.example.BookMyShow_Backend.Models.UserEntity;
import com.example.BookMyShow_Backend.RequestDTO.TicketResponseDTO;
import com.example.BookMyShow_Backend.RequestDTO.UserRequestDTO;
import com.example.BookMyShow_Backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public String addUser(@RequestBody UserRequestDTO userRequestDTO)
    {
        String result= userService.addUser(userRequestDTO);
        return result;
    }

    @GetMapping("/find_user_by_name")
    public UserEntity findByName(@RequestParam("name") String name)
    {
        return userService.findByName(name);
    }

    @GetMapping("/find_all_users")
    public List<UserEntity> findAll()
    {
        return userService.findAll();
    }

    @GetMapping("/get_tickets")
    public List<TicketResponseDTO> getAllTickets(@RequestParam("id") Integer id)
    {
        return userService.getAllTickets(id);
    }
}
