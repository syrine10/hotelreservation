package com.hotelreservation.Reservationservice.controller;

import com.hotelreservation.Reservationservice.model.Reservation;
import com.hotelreservation.Reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping(value = "/reservations")
    public List<Reservation> getallReservation(){
       List<Reservation> reservation = reservationRepository.findAll();
        return reservation ;
    }



    @PostMapping(value = "/reservations")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation
    ){

        Reservation newReservtion = reservationRepository.save(reservation);

        //if(nouvelleReservtion == null) throw new ImpossibleAjouterReservationException("Impossible d'ajouter cette reservation");

        return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
    }

    @GetMapping(value = "/reservations/{id}")
    public Optional<Reservation> getReservation(@PathVariable Long id){

        Optional<Reservation> reservation = reservationRepository.findById(id.intValue());

        //if(!reservation.isPresent()) throw new ReservatioNotFoundException("Cette reservation n'existe pas");

        return reservation;
    }

    @DeleteMapping(value="rooms/{id}")
    public void deleteReservation(@PathVariable Long id){
        Optional<Reservation> reservation = reservationRepository.findById(id.intValue());
        reservationRepository.deleteById(id.intValue());
    }
}
