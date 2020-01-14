package com.hotelreservation.Customerrepository;

import com.hotelreservation.Customermodel.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long> {

}
