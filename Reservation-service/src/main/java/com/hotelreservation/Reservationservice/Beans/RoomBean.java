package com.hotelreservation.Reservationservice.Beans;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import lombok.Getter;

import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomBean {
    private Long id;
    private int nbBed;
    private int number;
    private int price;
    private boolean state;

}

