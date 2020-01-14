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

@FeignClient(name = "Cutomer-service", url = "localhost:4091")
public interface MicroserviceCustomerProxy  {
    @GetMapping(value = "clientPay/{idres}")
    void pay (Long idres);
    @GetMapping(value = "/customer/{id}")
    public CustomerBean getCust (@PathVariable Long id);
    @GetMapping ( value = "reservations/{idCust}")
    List<ReservationBean> getAllReservation (@PathVariable Long idCust);
    @PostMapping(value = "customer")
    CustomerBean addClient (@RequestBody CustomerBean customer) ;
    @PostMapping(value = "Reserver")
    ReservationBean Reserver(@RequestBody  ReservationBean res) ;
}

