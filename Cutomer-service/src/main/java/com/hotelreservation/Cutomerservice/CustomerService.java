package com.hotelreservation.Cutomerservice;

import com.hotelreservation.Customerrepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRep ;


}
