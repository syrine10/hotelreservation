package com.hotelreservation.Reservationservice.repository;

import com.hotelreservation.Reservationservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
