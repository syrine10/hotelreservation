package com.hotelreservation.roomservice.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    private int nbBed;
    private int number;
    private int price;
}
