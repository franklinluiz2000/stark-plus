package com.client.ws.ws_stark_plus.exception;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
	super(message);
    }
}
