package com.hotelreservation.Reservationservice.controller;

import com.hotelreservation.Reservationservice.model.Reservation;
import com.hotelreservation.Reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @PostMapping(value = "/reservations")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation
    ){

        Reservation newReservtion = reservationRepository.save(reservation);

        //if(nouvelleReservtion == null) throw new ImpossibleAjouterReservationException("Impossible d'ajouter cette reservation");

        return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
    }

    @GetMapping(value = "/reservations/{id}")
    public Optional<Reservation> getReservation(@PathVariable int id){

        Optional<Reservation> reservation = reservationRepository.findById(id);

        //if(!reservation.isPresent()) throw new ReservatioNotFoundException("Cette reservation n'existe pas");

        return reservation;
    }
}
