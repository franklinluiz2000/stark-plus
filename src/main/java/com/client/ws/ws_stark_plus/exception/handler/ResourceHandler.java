package com.client.ws.ws_stark_plus.exception.handler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.client.ws.ws_stark_plus.dto.error.ErrorResponseDto;
import com.client.ws.ws_stark_plus.exception.BadRequestException;
import com.client.ws.ws_stark_plus.exception.NotFoudException;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(NotFoudException.class)
    public ResponseEntity<ErrorResponseDto> notFoundException(NotFoudException n) {
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseDto.builder().message(n.getMessage())
		.httpStatus(HttpStatus.NOT_FOUND).statusCode(HttpStatus.NOT_FOUND.value()).build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(BadRequestException b) {
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder().message(b.getMessage())
		.httpStatus(HttpStatus.BAD_REQUEST).statusCode(HttpStatus.BAD_REQUEST.value()).build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(MethodArgumentNotValidException m) {

	Map<String, String> messages = new HashMap<>();
	m.getBindingResult().getAllErrors().forEach(error -> {
	    String field = ((FieldError) error).getField();
	    String defaultMessage = error.getDefaultMessage();
	    messages.put(field, defaultMessage);
	});

	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		.body(ErrorResponseDto.builder().message(Arrays.toString(messages.entrySet().toArray()))
			.httpStatus(HttpStatus.BAD_REQUEST).statusCode(HttpStatus.BAD_REQUEST.value()).build());
    }
}