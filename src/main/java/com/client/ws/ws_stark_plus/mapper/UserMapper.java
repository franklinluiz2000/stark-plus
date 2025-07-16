package com.client.ws.ws_stark_plus.mapper;

import com.client.ws.ws_stark_plus.dto.UserDto;
import com.client.ws.ws_stark_plus.model.SubscriptionType;
import com.client.ws.ws_stark_plus.model.User;
import com.client.ws.ws_stark_plus.model.UserType;

public class UserMapper {
    public static User fromDtoToEntity(UserDto dto, UserType userType, SubscriptionType subscriptionType) {
	return User.builder().id(dto.getId()).name(dto.getName()).cpf(dto.getCpf()).email(dto.getEmail())
		.phone(dto.getPhone()).dtSubscription(dto.getDtSubscription()).dtExpiration(dto.getDtExpiration())
		.userType(userType).subscriptionType(subscriptionType).build();
    }
}
