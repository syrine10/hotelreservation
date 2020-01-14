package com.hotelreservation.roomservice.repository;

import com.hotelreservation.roomservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
     boolean findByNbBed(int nb);
    boolean findByNumber(int nb);
    List<Room> getByState(boolean state);
    boolean findByPrice(int price);
    int getByPrice(int price);
    Room getByNumber(int nb);
    List<Room> getByNbBed(int nb);
}
