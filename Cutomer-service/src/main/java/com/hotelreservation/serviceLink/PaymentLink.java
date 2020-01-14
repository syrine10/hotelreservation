package com.hotelreservation.serviceLink;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Payment-service", url = "localhost:4701")
public interface PaymentLink {
    @GetMapping(value = "/payment/{id}")
    public void payReservation(@PathVariable Long id) ;

}
