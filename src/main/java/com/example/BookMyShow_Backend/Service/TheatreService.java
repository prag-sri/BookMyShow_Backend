package com.example.BookMyShow_Backend.Service;

import com.example.BookMyShow_Backend.Enums.SeatType;
import com.example.BookMyShow_Backend.Models.TheatreEntity;
import com.example.BookMyShow_Backend.Models.TheatreSeatEntity;
import com.example.BookMyShow_Backend.Repositories.TheatreRepository;
import com.example.BookMyShow_Backend.Repositories.TheatreSeatRepository;
import com.example.BookMyShow_Backend.RequestDTO.TheatreRequestDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.BookMyShow_Backend.Enums.SeatType.CLASSIC;
import static com.example.BookMyShow_Backend.Enums.SeatType.PLATINUM;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    public String addTheatre(TheatreRequestDTO theatreRequestDTO)
    {
        TheatreEntity theatreEntity= TheatreEntity.builder()
                .name(theatreRequestDTO.getName())
                .city(theatreRequestDTO.getCity())
                .address(theatreRequestDTO.getAddress()).build();

        List<TheatreSeatEntity> theatreSeatEntityList= createTheatreSeats();

        theatreEntity.setTheatreSeatsList(theatreSeatEntityList);

        for(TheatreSeatEntity theatreSeatEntity: theatreSeatEntityList)
        {
            theatreSeatEntity.setTheatre(theatreEntity);
        }

        try
        {
            theatreRepository.save(theatreEntity);      //theatreSeatEntity is also getting saved here as list associated with theatre is getting saved with theatreSeatEntity
        }catch(Exception e) {
            return "Could not save Theatre!";
        }

        return "Theatre added successfully!";
    }

    public List<TheatreSeatEntity> createTheatreSeats(){
        List<TheatreSeatEntity> seatEntityList= new ArrayList<>();
        for(int i=1; i<=5; i++)
        {
            String seatNo= "1"+(char)('A'+i-1);
            TheatreSeatEntity theatreSeat1= new TheatreSeatEntity(seatNo,CLASSIC,100);
            seatEntityList.add(theatreSeat1);
            seatNo= "2"+(char)('A'+i-1);
            TheatreSeatEntity theatreSeat2= new TheatreSeatEntity(seatNo,PLATINUM,200);
            seatEntityList.add(theatreSeat2);
        }
//        TheatreSeatEntity theatreSeat1= new TheatreSeatEntity("1A",CLASSIC,100);
//        TheatreSeatEntity theatreSeat2= new TheatreSeatEntity("1B",CLASSIC,100);
//        TheatreSeatEntity theatreSeat3= new TheatreSeatEntity("1C",CLASSIC,100);
//        TheatreSeatEntity theatreSeat4= new TheatreSeatEntity("1D",CLASSIC,100);
//        TheatreSeatEntity theatreSeat5= new TheatreSeatEntity("1E",CLASSIC,100);

//        TheatreSeatEntity theatreSeat6= new TheatreSeatEntity("2A",PLATINUM,200);
//        TheatreSeatEntity theatreSeat7= new TheatreSeatEntity("2B",PLATINUM,200);
//        TheatreSeatEntity theatreSeat8= new TheatreSeatEntity("2C",PLATINUM,200);
//        TheatreSeatEntity theatreSeat9= new TheatreSeatEntity("2D",PLATINUM,200);
//        TheatreSeatEntity theatreSeat10= new TheatreSeatEntity("2E",PLATINUM,200);
//
//        seatEntityList.add(theatreSeat1);
//        seatEntityList.add(theatreSeat2);
//        seatEntityList.add(theatreSeat3);
//        seatEntityList.add(theatreSeat4);
//        seatEntityList.add(theatreSeat5);
//        seatEntityList.add(theatreSeat6);
//        seatEntityList.add(theatreSeat7);
//        seatEntityList.add(theatreSeat8);
//        seatEntityList.add(theatreSeat9);
//        seatEntityList.add(theatreSeat10);

        theatreSeatRepository.saveAll(seatEntityList);
        return seatEntityList;
    }
}
