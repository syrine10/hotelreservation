package com.hotelreservation.Cutomerservice;

import com.hotelreservation.Customermodel.Customer;
import com.hotelreservation.Customerrepository.CustomerRepository;
import com.hotelreservation.neededbeans.Reservation;
import com.hotelreservation.serviceLink.PaymentLink;
import com.hotelreservation.serviceLink.ReservationLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRep ;

    @Autowired
    ReservationLink resLink ;

    @Autowired
    PaymentLink payLink;




    public Customer getCustomer (Long id ){
        return customerRep.findById(id).get();
    }

    public List<Customer> getAllCustomer (){
        return customerRep.findAll();
    }

    public List<Reservation> getReservation (Long id ){

        return resLink.reservationsOfCustomer(id);

    }

    public Customer addCustomer ( Customer cst ){

        return customerRep.save(cst);
    }

    public void payerRes (Long id){

        payLink.payReservation(id);
    }



    public Reservation Reserver (Reservation  res){


        return resLink.Reserver(res).getBody();
    }


}
