package com.example.BookMyShow_Backend.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="theatre")
@Data
@NoArgsConstructor
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String address;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<TheatreSeatEntity> theatreSeats;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<ShowEntity> listOfShows;
}
