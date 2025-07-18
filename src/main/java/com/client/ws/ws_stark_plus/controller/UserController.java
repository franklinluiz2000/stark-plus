package com.client.ws.ws_stark_plus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.ws.ws_stark_plus.dto.UserDto;
import com.client.ws.ws_stark_plus.model.User;
import com.client.ws.ws_stark_plus.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserDto dto) {
	return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }
}
