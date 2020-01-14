package com.hotelreservation.Reservationservice.controller;

import com.hotelreservation.Reservationservice.model.Reservation;
import com.hotelreservation.Reservationservice.repository.ReservationRepository;
import com.hotelreservation.Reservationservice.service.ReservationService;
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
    ReservationService reservationService ;

    @GetMapping(value = "/reservations")
    public List<Reservation> getallReservation(){
       List<Reservation> reservation = reservationRepository.findAll();
        return reservation ;
    }



    @PostMapping(value = "/reservations")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
        List<Reservation> listeReserv=reservationRepository.findAll() ;
        int i=0 ;
        while (i< listeReserv.size()) {
            if (reservation.getDateReservationfin().compareTo(reservationRepository.findAll().get(i).getDateReservationdebut())<0) {
                Reservation newReservtion = reservationRepository.save(reservation);
                break;
            }
            i++;
        }
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

    @PutMapping(value="/reservations")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {

        reservationService.findById(reservation.getId());


        Reservation updatedReservation = reservationService.updateReservation(reservation);

        return ResponseEntity.ok().body(updatedReservation);
    }

}
