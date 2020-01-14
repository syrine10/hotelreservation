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
    private  long customerId ;

    private Date dateReservation;

    private Integer type;

    private Boolean roomState;

    public Reservation() {
    }

    public Reservation(long id, Integer roomId,long customerId, Date dateReservation, Integer type, Boolean roomState) {
        this.id = id;
        this.roomId = roomId;
        this.customerId=customerId ;
        this.dateReservation = dateReservation;
        this.type = type;
        this.roomState = roomState;
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getRoomState() {
        return roomState;
    }

    public void setRoomState(Boolean roomState) {
        this.roomState = roomState;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", roomId=" + roomId +
                "customerId=" + customerId +
                ", dateReservation=" + dateReservation +
                ", type=" + type +
                ", roomState=" + roomState +
                '}';
    }
}

