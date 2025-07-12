package com.client.ws.ws_stark_plus.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.ws.ws_stark_plus.exception.NotFoudException;
import com.client.ws.ws_stark_plus.model.SubscriptionType;
import com.client.ws.ws_stark_plus.repository.SubscriptionTypeRepository;
import com.client.ws.ws_stark_plus.service.SubscriptionTypeService;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    @Autowired
    private SubscriptionTypeRepository subscriptionTypeRepository;

    @Override
    public List<SubscriptionType> findAll() {
	return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
	Optional<SubscriptionType> optionalSubscriptionType = subscriptionTypeRepository.findById(id);
	if (optionalSubscriptionType.isEmpty()) {
	    throw new NotFoudException("SubscriptionType não encontrado");
	}

	return optionalSubscriptionType.get();
    }

    @Override
    public SubscriptionType create(SubscriptionType subscriptionType) {
	return null;
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionType subscriptionType) {
	return null;
    }

    @Override
    public void delete(Long id) {

    }
}