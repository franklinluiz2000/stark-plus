package com.client.ws.ws_stark_plus.mapper;

import com.client.ws.ws_stark_plus.dto.SubscriptionTypeDto;
import com.client.ws.ws_stark_plus.model.SubscriptionType;

public class SubscriptionTypeMapper {

    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto dto) {
	return SubscriptionType.builder().id(dto.getId()).name(dto.getName()).accessMonths(dto.getAccessMonths())
		.price(dto.getPrice()).productKey(dto.getProductKey()).build();
    }

}