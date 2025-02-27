package com.annaseva.controller;

import java.util.List;

import com.annaseva.response.PaymentResponse;
import com.annaseva.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annaseva.model.Order;
import com.annaseva.model.User;
import com.annaseva.request.OrderRequest;
import com.annaseva.service.OrderService;
import com.annaseva.service.UserService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private UserService userService;

	@PostMapping("/order")
	public ResponseEntity<PaymentResponse> createOrder(@RequestBody OrderRequest req, @RequestHeader("Authorization") String jwt)
			throws Exception {

		User user = userService.findUserByJwtToken(jwt);

		Order order = orderService.createOrder(req, user);
		PaymentResponse res = paymentService.createPaymentLink(order);

		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	@GetMapping("/order/user")
	public ResponseEntity<List<Order>> getOrderHistory(@RequestHeader("Authorization") String jwt) throws Exception {

		User user = userService.findUserByJwtToken(jwt);
		List<Order> orders = orderService.getUsersOrder(user.getId());

		return new ResponseEntity<>(orders, HttpStatus.OK);

	}

}
