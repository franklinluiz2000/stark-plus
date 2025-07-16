package com.client.ws.ws_stark_plus.service;

import com.client.ws.ws_stark_plus.dto.UserDto;
import com.client.ws.ws_stark_plus.model.User;

public interface UserService {

    User create(UserDto dto);
}