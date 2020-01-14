package com.hotelreservation.Customercontroller;


import com.hotelreservation.Customermodel.Customer;
import com.hotelreservation.Cutomerservice.CustomerService;
import com.hotelreservation.neededbeans.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")

public class CustomerController {

    @Autowired
    CustomerService custService ;

    @GetMapping(value = "clientPay/{idres}")
    void pay (Long idres){
        custService.payerRes (idres);
    }

    @GetMapping(value = "/customer/{id}")
    public Customer getCust (@PathVariable Long id){
        return custService.getCustomer(id);
    }

    @GetMapping ( value = "reservations/{idCust}")
    List<Reservation> getAllReservation (@PathVariable Long idCust){
        return  custService.getReservation(idCust);
    }

    @PostMapping(value = "customer")
    Customer addClient (@RequestBody Customer customer){

        return custService.addCustomer(customer);
    }


    @PostMapping(value = "Reserver")
    Reservation Reserver(@RequestBody  Reservation res){
        return custService.Reserver(res);
    }

}
