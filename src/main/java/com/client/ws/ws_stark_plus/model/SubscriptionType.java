package com.client.ws.ws_stark_plus.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "subscriptions_type")
@Entity
public class SubscriptionType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscriptions_type_id")
    private Long id;

    private String name;

    @Column(name = "access_months")
    private Long accessMonth;

    private BigDecimal price;

    @Column(name = "product_key")
    private String productKey;

    public SubscriptionType(Long id, String name, Long accessMonth, BigDecimal price, String productKey) {
	this.id = id;
	this.name = name;
	this.accessMonth = accessMonth;
	this.price = price;
	this.productKey = productKey;
    }

    public SubscriptionType() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Long getAccessMonth() {
	return accessMonth;
    }

    public void setAccessMonth(Long accessMonth) {
	this.accessMonth = accessMonth;
    }

    public BigDecimal getPrice() {
	return price;
    }

    public void setPrice(BigDecimal price) {
	this.price = price;
    }

    public String getProductKey() {
	return productKey;
    }

    public void setProductKey(String productKey) {
	this.productKey = productKey;
    }
}