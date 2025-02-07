package com.annaseva.request;

import com.annaseva.model.Address;

import lombok.Data;

@Data
public class OrderRequest {

	private Long restaurantId;
	private Address deliveryAddress;

}
