package com.hotelreservation.Paymentservice.Beans;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CustomerBean {
    private long id;
    private String name;
    private BigDecimal solde;
}

