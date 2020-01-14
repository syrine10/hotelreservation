package com.hotelreservation.roomservice.Exception;

import java.time.Instant;


public class AppError {
	
	private int code;
    private String message;
    private Instant timestamp;

    public AppError(int code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = Instant.now();
    }

}
