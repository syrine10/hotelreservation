package com.reservationhotel.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reservationhotel.app.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository CustomerRepository;
	
}
