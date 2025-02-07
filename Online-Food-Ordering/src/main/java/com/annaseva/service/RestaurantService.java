package com.annaseva.service;

import java.util.List;

import com.annaseva.dto.RestaurantDto;
import com.annaseva.model.Restaurant;
import com.annaseva.model.User;
import com.annaseva.request.CreateRestaurantRequest;

public interface RestaurantService {

	public Restaurant createRestaurant(CreateRestaurantRequest req, User user);

	public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception;

	public void deleteRestaurant(Long restaurantId) throws Exception;

	public List<Restaurant> getAllRestaurant();

	public List<Restaurant> searchRestaurant(String keyword);

	public Restaurant findRestaurantById(Long id) throws Exception;

	public Restaurant getRestaurantByUserId(Long userId) throws Exception;

	public RestaurantDto addToFavouities(Long restaurantId, User user) throws Exception;

	public Restaurant updateRestaurantStatus(Long id) throws Exception;

}
