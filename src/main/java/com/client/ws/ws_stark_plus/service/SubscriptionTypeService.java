package com.client.ws.ws_stark_plus.service;

import java.util.List;

import com.client.ws.ws_stark_plus.dto.SubscriptionTypeDto;
import com.client.ws.ws_stark_plus.model.SubscriptionType;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();

    SubscriptionType findById(Long id);

    SubscriptionType create(SubscriptionTypeDto dto);

    SubscriptionType update(Long id, SubscriptionTypeDto dto);

    void delete(Long id);
}
