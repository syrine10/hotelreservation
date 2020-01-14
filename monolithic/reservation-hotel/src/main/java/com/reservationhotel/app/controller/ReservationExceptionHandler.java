package com.reservationhotel.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.reservationhotel.app.exception.AppError;
import com.reservationhotel.app.exception.NoAvailableRoomException;

@RestControllerAdvice
public class ReservationExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public AppError noHandlerFoundException(NoHandlerFoundException ex) {
		return new AppError(1000, "request with no handler !!");
	}

	@ExceptionHandler(NoAvailableRoomException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public AppError noAvailableRoomsException(NoAvailableRoomException ex) {
		return new AppError(666, ex.getMessage());
	}
}
