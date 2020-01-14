package com.hotelreservation.roomservice.controller;

import com.hotelreservation.roomservice.Exception.NoAvailableRoomException;
import com.hotelreservation.roomservice.model.Room;
import com.hotelreservation.roomservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @GetMapping(value="rooms/{id}")
    ResponseEntity<Room> getProduct (@PathVariable Long  id) throws NoAvailableRoomException {


        Room room = roomRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED,"room not found = "+id));

        return ResponseEntity.ok().body(room);

    }



    @GetMapping(value="rooms")
    List<Room> getAllProducts () {


        List<Room> rooms = roomRepository.findAll();
        return rooms;




    }

    @PostMapping(value = "rooms")
    ResponseEntity<Room> addNewRoom (@RequestBody Room room){

        Room newRoom = roomRepository.save(room);
        return ResponseEntity.ok().body(newRoom);
    }

    @GetMapping(value="rooms/available")
    List<Room>  getAvailableRoom (){

        List <Room> rooms = roomRepository.getByState(true);
        return rooms;
    }


    @DeleteMapping(value="rooms/{id}")
    public void deleteRoom(@PathVariable Long id) throws  ResponseStatusException {

        Room prod = roomRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED,"room  "+id+" not found "));
        roomRepository.deleteById(id);


    }



}

