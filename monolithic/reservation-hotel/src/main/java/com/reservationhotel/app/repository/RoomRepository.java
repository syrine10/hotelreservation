package com.reservationhotel.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservationhotel.app.model.Room;
import com.reservationhotel.app.utils.RoomType;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

	 List<Room> findByType(RoomType type);
	 List<Room> getRoomByType(RoomType type);


}
