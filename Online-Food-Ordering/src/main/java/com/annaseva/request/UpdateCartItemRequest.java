package com.annaseva.request;

import lombok.Data;

@Data
public class UpdateCartItemRequest {

	private Long cartItemId;
	private int quantity;

}
