package com.hotelreservation.roomservice.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private boolean state;
}
