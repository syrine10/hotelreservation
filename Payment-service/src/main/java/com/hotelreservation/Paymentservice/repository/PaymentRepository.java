package com.hotelreservation.Paymentservice.repository;

import com.hotelreservation.Paymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository <Payment, Long> {
    Payment findByidReservation(Long idReservation);
}
