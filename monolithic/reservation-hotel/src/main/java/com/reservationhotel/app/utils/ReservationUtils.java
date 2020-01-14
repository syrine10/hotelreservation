package com.reservationhotel.app.utils;

import java.time.LocalDate;
import java.util.List;

import com.reservationhotel.app.model.Reservation;

public class ReservationUtils {

	 public static boolean isBookingAvailable(List<Reservation> reservationList, LocalDate beginDate, LocalDate endDate) {
	        boolean isAvailable = false;

	        for(Reservation booking : reservationList) {
	            isAvailable = !areDatesOverlapping(booking.getArrival(), booking.getDeparture(), beginDate, endDate);
	        }

	        return isAvailable;
	    }

	    private static boolean areDatesOverlapping(LocalDate startDate1, LocalDate endDate1, LocalDate startDate2,
	                                               LocalDate endDate2) {
	        return startDate1.isBefore(endDate2) && endDate1.isAfter(startDate2);
	    }
}
