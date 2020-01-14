package com.reservationhotel.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservationhotel.app.model.Room;
import com.reservationhotel.app.repository.RoomRepository;
import com.reservationhotel.app.utils.RoomType;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	 public List<Room> getHotelRoomBySize(RoomType type) {
		 
		//if(type.equalsIgnoreCase(RoomType.DOUBLE.toString()))
	        return roomRepository.findByType(type);
	    }
	
	
}
