package com.hotelreservation.Paymentservice.Beans;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString
public class ReservationBean {
    private Long id;
    private Long idClient;
    private Long idProduct;
    private Date dateCommande;
    private BigDecimal amount ;
    private int quantity ;
    private Boolean isPayed=false;

}
