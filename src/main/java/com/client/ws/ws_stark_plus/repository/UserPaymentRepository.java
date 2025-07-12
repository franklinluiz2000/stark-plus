package com.client.ws.ws_stark_plus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.ws.ws_stark_plus.model.UserPaymentInfo;

@Repository
public interface UserPaymentRepository extends JpaRepository<UserPaymentInfo, Long> {

}
