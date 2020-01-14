package com.hotelreservation.Paymentservice.Proxy;

import com.hotelreservation.Paymentservice.Beans.ReservationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Reservation-service", url = "localhost:4093")
public interface MicroserviceReservationProxy {

    @GetMapping(value = "/reservations")
    public List<ReservationBean> getallReservation();

    @PostMapping(value = "/reservations")
    public ResponseEntity<ReservationBean> addReservation(@RequestBody ReservationBean reservation
    );
    @GetMapping(value = "/reservations/{id}")
    public Optional<ReservationBean> getReservation(@PathVariable int id);
    @DeleteMapping(value="rooms/{id}")
    public void deleteReservation(@PathVariable Long id);
    @PutMapping(value="/reservations")
    public ResponseEntity<ReservationBean> updateReservation(@RequestBody ReservationBean reservation);

}

