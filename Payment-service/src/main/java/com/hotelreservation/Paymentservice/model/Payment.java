package com.hotelreservation.Paymentservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Payment {
    //id du payement
    @Id
    @GeneratedValue
    private long id;
    //id du commande
    private long idCommande;
    private long idClient;
    private long idProduit;
    private int quantity;
}

