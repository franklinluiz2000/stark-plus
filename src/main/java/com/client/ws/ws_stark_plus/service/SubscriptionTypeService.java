package com.client.ws.ws_stark_plus.service;

import java.util.List;

import com.client.ws.ws_stark_plus.model.SubscriptionType;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();

    SubscriptionType findById(Long id);

    SubscriptionType create(SubscriptionType subscriptionType);

    SubscriptionType update(Long id, SubscriptionType subscriptionType);

    void delete(Long id);
}
