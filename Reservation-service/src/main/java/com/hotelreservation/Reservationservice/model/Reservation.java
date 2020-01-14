package com.hotelreservation.Reservationservice.model;

//package com.mcommandes.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long id;

    private Integer roomId;
    private  Long customerId ;

    private Date dateReservationdebut;

    private Date dateReservationfin;

    //private Integer type;

    //private Boolean roomState;

    public Reservation() {
    }

    public Reservation(long id, Integer roomId,Long customerId, Date dateReservationdebut,Date dateReservationfin) {
        this.id = id;
        this.roomId = roomId;
        this.customerId=customerId ;
        this.dateReservationdebut = dateReservationdebut;
        this.dateReservationfin = dateReservationfin;


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getDateReservationdebut() {
        return dateReservationdebut;
    }

    public void setDateReservationdebut(Date dateReservationdebut) {
        this.dateReservationdebut = dateReservationdebut;
    }

    public Date getDateReservationfin() {
        return dateReservationfin;
    }

    public void setDateReservationfin(Date dateReservationfin) {
        this.dateReservationfin = dateReservationfin;
    }



    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", roomId=" + roomId +
                "customerId=" + customerId +
                ", dateReservationdebut=" + dateReservationdebut +
                ", dateReservationfin=" + dateReservationfin +
                '}';
    }
}

