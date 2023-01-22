package com.example.BookMyShow_Backend.Models;

import com.example.BookMyShow_Backend.Enums.SeatType;
import jakarta.persistence.*;
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
}
