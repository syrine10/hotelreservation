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
    private Long customerId;
    private Long roomId;
    private Date dateReservationdebut;
    private Date dateReservationfin ;

    //private Boolean isPayed=false;

}
