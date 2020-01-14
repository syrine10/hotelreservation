package com.reservationhotel.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reservationhotel.app.exception.NoAvailableRoomException;
import com.reservationhotel.app.model.Reservation;
import com.reservationhotel.app.repository.ReservationRepository;
import com.reservationhotel.app.service.ReservationService;
import com.reservationhotel.app.utils.RoomType;

@RestController
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private ReservationRepository reservationRepository;

	@GetMapping("/bookRoom")
	@ResponseBody
	public String bookHotelRoom(@RequestParam(value = "roomSize") RoomType roomType,
			@RequestParam(value = "arrival") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@RequestParam(value = "departure") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate)
			throws NoAvailableRoomException {
		reservationService.createReservation(roomType, startDate, endDate);
		return "OK";
	}

	@DeleteMapping("/cancelBooking")
	@ResponseBody
	public String cancelBooking(@RequestParam(value = "id") Long bookingId) {
		
		reservationService.cancelBooking(reservationRepository.getById(bookingId));
		return "OK";
	}

	@GetMapping("/getAllBookings")
	public List<Reservation> getAllBookings() {
		return reservationService.getAllBookings();
	}

}
