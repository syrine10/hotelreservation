package com.reservationhotel.app.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservationhotel.app.exception.NoAvailableRoomException;
import com.reservationhotel.app.model.Reservation;
import com.reservationhotel.app.model.Room;
import com.reservationhotel.app.repository.ReservationRepository;
import com.reservationhotel.app.repository.RoomRepository;
import com.reservationhotel.app.utils.ReservationUtils;
import com.reservationhotel.app.utils.RoomType;


@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	 public Reservation createReservation(RoomType roomType, LocalDate arrival, LocalDate departure) throws NoAvailableRoomException {
	        Room room = getHotelRoomForBooking(roomType, arrival, departure);
	        Reservation reservation = new Reservation();
	        reservation.setRoom(room);
	        reservation.setArrival(arrival);
	        reservation.setDeparture(departure);
	        return reservationRepository.save(reservation);
	    }
	
	  public Room getHotelRoomForBooking(RoomType roomType, LocalDate beginDate, LocalDate endDate) throws NoAvailableRoomException {
	        List<Room> roomList =roomRepository.getRoomByType(roomType);
	       // logger.info(String.format("found %d rooms with size %d", hotelRoomList.size(), roomSize));
	        if (!roomList.isEmpty()) {
	            Map<Room, List<Reservation>> bookingsForHotelRoom = new HashMap<>();

	            for (Room hotelRoom : roomList) {
	                List<Reservation> futureBookingsForHotelRoom = checkIsRoomHasActiveBookings(hotelRoom, beginDate);
	                if (futureBookingsForHotelRoom.isEmpty()) return hotelRoom;
	                bookingsForHotelRoom.put(hotelRoom, futureBookingsForHotelRoom);
	            }

	            for (Map.Entry<Room, List<Reservation>> entry : bookingsForHotelRoom.entrySet()) {
	                if (ReservationUtils.isBookingAvailable(entry.getValue(), beginDate, endDate)) return entry.getKey();
	            }

	        }
	        throw new NoAvailableRoomException();
	    }

	  
	    public List<Reservation> getAllBookings() {
	        return reservationRepository.findAll();
	    }

	 
	    public void cancelBooking(Reservation bookingId) {
	    	//*****************//// 
	        reservationRepository.delete(bookingId);
	    }

	    private List<Reservation> checkIsRoomHasActiveBookings(Room hotelRoom, LocalDate startDate) {
	        return reservationRepository.findByHotelRoomAndEndDateGreaterThanOrderByEndDateAsc(hotelRoom, startDate);
	    }

}
