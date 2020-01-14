package com.hotelreservation.Reservationservice.service;

//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import com.hotelreservation.Reservationservice.model.Reservation;
import com.hotelreservation.Reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> findAll(){
        return this.reservationRepository.findAll();
    }

    public Optional<Reservation> findById(Long id) {

        Optional<Reservation> reservation = reservationRepository.findById(id.intValue());

        //if (!reservation.isPresent()) {throw new RerservationNotFoundException("reservation not found");}

        return reservation ;
    }

    public Reservation addReservation(Reservation reservation){

        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public void deletereservation (Long id){
        reservationRepository.deleteById(id.intValue());
    }

    public List<Reservation> getReservationsOfClient(Long id){

        return  reservationRepository.findAll()
                .stream()
                .filter(reservation -> reservation.getCustomerId().equals(id))
                .collect(Collectors.toList());
    }


}
