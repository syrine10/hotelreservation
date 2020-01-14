package com.reservationhotel.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservationhotel.app.model.Reservation;
import com.reservationhotel.app.model.Room;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	List<Reservation> findByHotelRoomAndEndDateGreaterThanOrderByEndDateAsc(Room hotelRoom, LocalDate date);

	Reservation getById(Long bookingId);
}
