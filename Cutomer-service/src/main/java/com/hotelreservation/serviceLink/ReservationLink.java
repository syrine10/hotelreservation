package com.hotelreservation.serviceLink;


import com.hotelreservation.neededbeans.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Reservation-service", url = "localhost:4701")
public interface ReservationLink {

    @GetMapping(value = "/reservations/{id}")
    public ResponseEntity<Reservation> getreservation(@PathVariable Long id) ;


    @PutMapping(value = "/reservations")
    public ResponseEntity<Reservation> updatereservation(@RequestBody Reservation commande);



    @PostMapping(value = "/reservations" )
    public ResponseEntity<Reservation> Reserver (@RequestBody Reservation commande);


    @DeleteMapping(value = "/reservations/{id}")
    public void CancelReservation(@PathVariable Long id);



    @GetMapping(value = "/reservations")
    public List<Reservation> allReservations();


    @GetMapping(value = "/reservations/customer/{id}")
    public List<Reservation> reservationsOfCustomer (@PathVariable Long id);

}
