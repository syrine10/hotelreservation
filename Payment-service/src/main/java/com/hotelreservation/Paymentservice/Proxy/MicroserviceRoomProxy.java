package com.hotelreservation.Paymentservice.Proxy;

import com.hotelreservation.Paymentservice.Beans.RoomBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@FeignClient(name = "produitMicroservice", url = "localhost:4700")
public interface MicroserviceRoomProxy {
    @GetMapping(value="/products/{id}")
    ResponseEntity<RoomBean> getProduct (@PathVariable Long  id) throws ResourceNotFoundException;
    @GetMapping(value="/products")
    List<RoomBean> getAllProducts ();

    @PostMapping(value = "/products")
    ResponseEntity<RoomBean> addproduct (@RequestBody RoomBean prod);

    @GetMapping(value="/products/{id}")
    void deleteProduct(@PathVariable Long id) throws ResponseStatusException;
}

