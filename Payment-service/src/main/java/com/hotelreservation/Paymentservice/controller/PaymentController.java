package com.hotelreservation.Paymentservice.controller;


import com.hotelreservation.Paymentservice.repository.PaymentRepository;
import com.hotelreservation.Paymentservice.service.PaymentService;
import com.hotelreservation.Paymentservice.Beans.ReservationBean;
import com.hotelreservation.Paymentservice.Beans.RoomBean;
import com.hotelreservation.Paymentservice.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PaymentController {

    @Autowired
    PaymentService paymentService;
    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping(value = "/payment/{commandeId}")
    public void  payerUneCommande(@PathVariable Long commandeId){
        paymentService.payerCommande(commandeId);
    }
    @GetMapping(value = "/testp")
    public List<RoomBean> TestProduit()
    {
        return paymentService.TestProduit();
    }
    @GetMapping(value = "/testc")
    public List<ReservationBean> TestCommande()
    {
        return paymentService.TestCommande();
    }

}
