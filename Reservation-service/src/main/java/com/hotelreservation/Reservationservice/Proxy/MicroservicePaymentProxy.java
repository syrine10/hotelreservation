package com.hotelreservation.Reservationservice.Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Payment-service", url = "localhost:4092")
public interface MicroservicePaymentProxy {
    @GetMapping(value = "/payment/{id}")
    public void payerunereservation(@PathVariable Long reservationId) ;

}
