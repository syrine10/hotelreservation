package com.hotelreservation.Paymentservice.Proxy;

import com.hotelreservation.Paymentservice.Beans.ReservationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "commandeMicroservice", url = "localhost:4701")
public interface MicroserviceReservationProxy {

    @GetMapping(value = "/commandes")
    public List<ReservationBean> allCommandes();

    @GetMapping(value = "/commandes/{id}")
    public ResponseEntity<ReservationBean> getCommande(@PathVariable Long id);


    @PutMapping(value = "/commandes")
    public ResponseEntity<ReservationBean> updateCommande(@RequestBody ReservationBean commande);



    @PostMapping(value = "/commandes" )
    public ResponseEntity<ReservationBean> passCommande (@RequestBody ReservationBean commande);


    @DeleteMapping(value = "/commande/{id}")
    public void deleteCommande(@PathVariable Long id);

}

