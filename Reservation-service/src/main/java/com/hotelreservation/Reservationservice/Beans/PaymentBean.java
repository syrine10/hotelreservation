package com.hotelreservation.Reservationservice.Beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentBean {

    private long id;

    private long idCommande;
    private long idClient;
    private long idProduit;
    private int quantity;
}

