package com.example.BookMyShow_Backend.Models;

import com.example.BookMyShow_Backend.Enums.SeatType;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="theatre_seats")
@Data
@NoArgsConstructor
public class TheatreSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    @Enumerated(value= EnumType.STRING)
    private SeatType seatType;
    private int rate;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatre;

    public TheatreSeatEntity(String seatNo, SeatType seatType, int rate) {
        this.seatNo= seatNo;
        this.seatType= seatType;
        this.rate= rate;
    }

    public int findRateBySeatNo(String seatNo)
    {
        return rate;
    }

}

//We are keeping structure of all the theatres same-> total seats= 10
//5 Classic and 5 platinum
//Classic-> 1A 1B 1C 1D 1E
//Platinum-> 2A 2B 2C 2D 2E
