package com.hotelreservation.Paymentservice.Proxy;

import com.hotelreservation.Paymentservice.Beans.CustomerBean;
import com.hotelreservation.Paymentservice.Beans.ReservationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@FeignClient(name = "clientMicroservice", url = "localhost:8080")
public interface MicroserviceCustomerProxy  {
    @GetMapping(value = "/client/{id}")
    Optional<CustomerBean> getClient(@PathVariable Long id);
    @PostMapping(value="/client")
    void addClient(@RequestBody CustomerBean client);
}

