package com.hotelreservation.Paymentservice.Beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomBean {
    private Long id ;
    private String name ;
    private BigDecimal price ;
    private int stockQuantity;
}

