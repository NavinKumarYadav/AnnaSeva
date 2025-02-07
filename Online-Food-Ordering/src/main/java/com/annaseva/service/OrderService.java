package com.annaseva.service;

import java.util.List;

import com.annaseva.model.Order;
import com.annaseva.model.User;
import com.annaseva.request.OrderRequest;

public interface OrderService {

	public Order createOrder(OrderRequest order, User user) throws Exception;

	public Order updateOrder(Long orderId, String orderStatus) throws Exception;

	public void cancelOrder(Long orderId) throws Exception;

	public List<Order> getUsersOrder(Long userId) throws Exception;

	public List<Order> getRestaurantsOrder(Long restaurantId, String orderStatus) throws Exception;

	public Order findOrderById(Long orderId) throws Exception;
}
