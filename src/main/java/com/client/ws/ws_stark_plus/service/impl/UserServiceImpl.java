package com.client.ws.ws_stark_plus.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.ws.ws_stark_plus.dto.UserDto;
import com.client.ws.ws_stark_plus.exception.BadRequestException;
import com.client.ws.ws_stark_plus.exception.NotFoudException;
import com.client.ws.ws_stark_plus.mapper.UserMapper;
import com.client.ws.ws_stark_plus.model.User;
import com.client.ws.ws_stark_plus.model.UserType;
import com.client.ws.ws_stark_plus.repository.UserRepository;
import com.client.ws.ws_stark_plus.repository.UserTypeRepository;
import com.client.ws.ws_stark_plus.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public User create(UserDto dto) {

	if (Objects.nonNull(dto.getId())) {
	    throw new BadRequestException("id deve ser nulo");
	}

	var userTypeOpt = userTypeRepository.findById(dto.getUserTypeId());

	if (userTypeOpt.isEmpty()) {
	    throw new NotFoudException("userTypeId não encontrado");
	}

	UserType userType = userTypeOpt.get();
	User user = UserMapper.fromDtoToEntity(dto, userType, null);
	return userRepository.save(user);
    }
}