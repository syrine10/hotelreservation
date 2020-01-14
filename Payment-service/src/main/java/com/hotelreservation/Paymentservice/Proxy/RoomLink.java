package com.hotelreservation.Paymentservice.Proxy;

import com.hotelreservation.Paymentservice.Beans.RoomBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

<<<<<<< HEAD:Payment-service/src/main/java/com/hotelreservation/Paymentservice/Proxy/RoomLink.java
@FeignClient(name = "Room-service", url = "localhost:4700")
public interface RoomLink {
=======
@FeignClient(name = "room-service", url = "localhost:4090")
public interface MicroserviceRoomProxy {
>>>>>>> 7a290330b8220ac7a04454db8835a15146cf3e18:Payment-service/src/main/java/com/hotelreservation/Paymentservice/Proxy/MicroserviceRoomProxy.java

   @GetMapping(value="rooms")
   List<RoomBean> getAllProducts ();
    @GetMapping(value="rooms/{id}")
    ResponseEntity<RoomBean> getProduct (@PathVariable Long  id) throws ResourceNotFoundException ;

        @PostMapping(value = "rooms")
   ResponseEntity<RoomBean> addNewRoom (@RequestBody RoomBean room) ;
    @DeleteMapping(value="rooms/{id}")
    public void deleteRoom(@PathVariable Long id) throws  ResponseStatusException;
}

