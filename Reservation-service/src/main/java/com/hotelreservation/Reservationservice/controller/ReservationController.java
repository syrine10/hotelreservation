package com.hotelreservation.Reservationservice.controller;

import com.hotelreservation.Reservationservice.Beans.RoomBean;
import com.hotelreservation.Reservationservice.Proxy.MicroserviceRoomProxy;
import com.hotelreservation.Reservationservice.Proxy.MicroservicePaymentProxy;

import com.hotelreservation.Reservationservice.Proxy.MicroservicePaymentProxy;
import com.hotelreservation.Reservationservice.Proxy.MicroserviceRoomProxy;
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

    MicroservicePaymentProxy microservicePaymentProxy ;
    MicroserviceRoomProxy microserviceRoomProxy ;


    @GetMapping(value = "/reservations")
    public List<Reservation> getallReservation(){
       List<Reservation> reservation = reservationRepository.findAll();
        return reservation ;
    }



    @PostMapping(value = "/reservations")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
        //List<Reservation> listeReserv=reservationRepository.findAll() ;
        int i=0 ;
        while (i< reservationRepository.findAll().size()) {
            if ((reservation.getDateReservationfin().compareTo(reservationRepository.findAll().get(i).getDateReservationdebut())<0)&(reservation.getDateReservationdebut().compareTo(reservationRepository.findAll().get(i).getDateReservationfin())>0)) {
                if(reservation.getType()==reservationRepository.findAll().get(i).getType()) {
                    Reservation newReservation = reservationService.addReservation(reservation);
                    microservicePaymentProxy.payerunereservation(reservationRepository.findAll().get(i).getId());


                    break;
                }
            }
            i++;
        }
        //if(nouvelleReservtion == null) throw new ImpossibleAjouterReservationException("Impossible d'ajouter cette reservation");

        return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
    }

    @GetMapping(value = "/reservations/{id}")
    public Optional<Reservation> getReservation(@PathVariable Long id){

        Optional<Reservation> reservation = reservationService.findById(id);

        //if(!reservation.isPresent()) throw new ReservatioNotFoundException("Cette reservation n'existe pas");

        return reservation;
    }

    @DeleteMapping(value="rooms/{id}")
    public void deleteReservation(@PathVariable Long id){
        Optional<Reservation> reservation = reservationRepository.findById(id.intValue());
        reservationService.deletereservation(id);
    }

    @PutMapping(value="/reservations")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {

        reservationService.findById(reservation.getId());


        Reservation updatedReservation = reservationService.updateReservation(reservation);

        return ResponseEntity.ok().body(updatedReservation);
    }

}
