package com.client.ws.ws_stark_plus.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.client.ws.ws_stark_plus.exception.NotFoudException;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(NotFoudException.class)
    public ResponseEntity<String> NotFoudException(com.client.ws.ws_stark_plus.exception.NotFoudException n) {
	String errorMessage = n.getMessage();
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
