package com.ashokit.gopi.bindings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT_DTLS")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRODUCT_PRICE")
	private Double productPrice;
	
}
