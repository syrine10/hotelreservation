package com.hotelreservation.Paymentservice.Beans;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CustomerBean {
    private long idCust;
    private String nom;
    private String prenom;
    private String adresse;
    private BigDecimal age;
}

