package com.hotelreservation.roomservice.repository;

import com.hotelreservation.roomservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> getRoomByNbBed(int nb);
}
