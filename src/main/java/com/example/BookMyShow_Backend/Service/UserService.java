package com.example.BookMyShow_Backend.Service;

import com.example.BookMyShow_Backend.Models.TicketEntity;
import com.example.BookMyShow_Backend.Models.UserEntity;
import com.example.BookMyShow_Backend.Repositories.UserRepository;
import com.example.BookMyShow_Backend.RequestDTO.TicketResponseDTO;
import com.example.BookMyShow_Backend.RequestDTO.UserRequestDTO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserRequestDTO userRequestDTO)
    {
        UserEntity userEntity= UserEntity.builder()
                .name(userRequestDTO.getName())
                .mobile(userRequestDTO.getMobile()).build();

        try{
            userRepository.save(userEntity);
        }catch(Exception e){
            return "User could not be added!";
        }
        return "User added successfully!";
    }

    public UserEntity findByName(String name)
    {
        for(UserEntity user: userRepository.findAll())
        {
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }

    public List<UserEntity> findAll()
    {
        List<UserEntity> listOfUsers= new ArrayList<>();
        for(UserEntity user: userRepository.findAll())
        {
            listOfUsers.add(user);
        }
        return listOfUsers;
    }

    public List<TicketResponseDTO> getAllTickets(Integer id)
    {
        UserEntity user= userRepository.findById(id).get();
        List<TicketEntity> usersTickets= user.getTicket();
        List<TicketResponseDTO> ticketsInfo= new ArrayList<>();
        for(TicketEntity ticket: usersTickets)
        {
            TicketResponseDTO t= new TicketResponseDTO(ticket);
            ticketsInfo.add(t);
        }
        return ticketsInfo;
    }
}
