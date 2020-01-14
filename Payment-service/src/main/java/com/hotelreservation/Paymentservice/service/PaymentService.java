package com.hotelreservation.Paymentservice.service;

import com.hotelreservation.Paymentservice.Proxy.ReservationLink;
import com.hotelreservation.Paymentservice.repository.PaymentRepository;
import com.hotelreservation.Paymentservice.Beans.CustomerBean;
import com.hotelreservation.Paymentservice.Beans.ReservationBean;
import com.hotelreservation.Paymentservice.Beans.RoomBean;
import com.hotelreservation.Paymentservice.model.Payment;
import com.hotelreservation.Paymentservice.Proxy.CustomerLink;
import com.hotelreservation.Paymentservice.Proxy.RoomLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ReservationLink reservationLink;
    @Autowired
    private RoomLink roomLink;
    @Autowired
    private CustomerLink customerLink;
    public void payerReservation(Long idReservation)
    {

        ReservationBean reservation= reservationLink.getReservation();

        Long idClient = reservation.getCustomerId();
        System.out.println(idClient);

        Payment payment =new Payment();

        Optional <CustomerBean> client= Optional.ofNullable(customerLink.getCust(idClient));

        //comparer le solde du client au valeur de la commande


    }
    public List<RoomBean> TestRoom()
    {
        return roomLink.getAllProducts();
    }
    public List <ReservationBean> TestReservation()
    {
        return reservationLink.getallReservation();
    }
}

