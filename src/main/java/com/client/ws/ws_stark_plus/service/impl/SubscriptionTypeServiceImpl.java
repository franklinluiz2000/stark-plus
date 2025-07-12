package com.client.ws.ws_stark_plus.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.ws.ws_stark_plus.dto.SubscriptionTypeDto;
import com.client.ws.ws_stark_plus.exception.BadRequestException;
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
	return getSubscriptionType(id);
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDto dto) {
	if (Objects.nonNull(dto.getId())) {
	    throw new BadRequestException("Id deve ser nulo");
	}
	return subscriptionTypeRepository.save(SubscriptionType.builder().id(dto.getId()).name(dto.getName())
		.accessMonth(dto.getAccessMonth()).price(dto.getPrice()).productKey(dto.getProductKey()).build());
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto dto) {
	getSubscriptionType(id);
	return subscriptionTypeRepository.save(SubscriptionType.builder().id(id).name(dto.getName())
		.accessMonth(dto.getAccessMonth()).price(dto.getPrice()).productKey(dto.getProductKey()).build());
    }

    @Override
    public void delete(Long id) {
	getSubscriptionType(id);
	subscriptionTypeRepository.deleteById(id);

    }

    public SubscriptionType getSubscriptionType(Long id) {
	Optional<SubscriptionType> optionalSubscriptionType = subscriptionTypeRepository.findById(id);
	if (optionalSubscriptionType.isEmpty()) {
	    throw new NotFoudException("SubscriptionType não encontrado");
	}

	return optionalSubscriptionType.get();
    }

}