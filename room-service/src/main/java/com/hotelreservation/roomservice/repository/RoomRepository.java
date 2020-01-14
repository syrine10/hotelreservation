package com.hotelreservation.roomservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository


@Repository
public class RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByNbBed(int nb);
    List<Room> getRoomByNbBed(int nb);
}
