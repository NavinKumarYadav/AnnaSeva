package com.annaseva.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annaseva.dto.RestaurantDto;
import com.annaseva.model.Address;
import com.annaseva.model.Restaurant;
import com.annaseva.model.User;
import com.annaseva.repository.AddressRepository;
import com.annaseva.repository.RestaurantRepository;
import com.annaseva.repository.UserRepository;
import com.annaseva.request.CreateRestaurantRequest;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {

		Address address = addressRepository.save(req.getAddress());

		Restaurant restaurant = new Restaurant();
		restaurant.setAddress(address);
		restaurant.setContactInformation(req.getContactInformation());
		restaurant.setCuisineType(req.getCuisineType());
		restaurant.setDescription(req.getDescription());
		restaurant.setImages(req.getImages());
		restaurant.setName(req.getName());
		restaurant.setOpeningHours(req.getOpeningHours());
		restaurant.setRegistrationDate(LocalDateTime.now());
		restaurant.setOwner(user);

		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception {

		Restaurant restaurant = findRestaurantById(restaurantId);

		if (restaurant.getCuisineType() != null) {
			restaurant.setCuisineType(updatedRestaurant.getCuisineType());
		}

		if (restaurant.getDescription() != null) {
			restaurant.setDescription(updatedRestaurant.getDescription());
		}

		if (restaurant.getName() != null) {
			restaurant.setName(updatedRestaurant.getName());
		}

		return restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(Long restaurantId) throws Exception {

		Restaurant restaurant = findRestaurantById(restaurantId);

		restaurantRepository.delete(restaurant);

	}

	@Override
	public List<Restaurant> getAllRestaurant() {

		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> searchRestaurant(String keyword) {

		return restaurantRepository.findBySearchQuery(keyword);
	}

	@Override
	public Restaurant findRestaurantById(Long id) throws Exception {

		Optional<Restaurant> optional = restaurantRepository.findById(id);

		if (optional.isEmpty()) {
			throw new Exception("restaurant not found with id" + id);
		}

		return optional.get();
	}

	@Override
	public Restaurant getRestaurantByUserId(Long userId) throws Exception {

		Restaurant restaurant = restaurantRepository.findByOwnerId(userId);

		if (restaurant == null) {
			throw new Exception("restaurant not found with owner id" + userId);
		}
		return restaurant;
	}

	@Override
	public RestaurantDto addToFavouities(Long restaurantId, User user) throws Exception {

		Restaurant restaurant = findRestaurantById(restaurantId);

		RestaurantDto dto = new RestaurantDto();
		dto.setDescription(restaurant.getDescription());
		dto.setImages(restaurant.getImages());
		dto.setTitle(restaurant.getName());
		dto.setId(restaurantId);

		boolean isFavorited = false;
		List<RestaurantDto> favorites = user.getFavorites();
		for (RestaurantDto favorite : favorites) {
			if (favorite.getId().equals(restaurantId)) {
				isFavorited = true;
				break;
			}
		}

		if (isFavorited) {
			favorites.removeIf(favorite -> favorite.getId().equals(restaurantId));
		} else {
			favorites.add(dto);
		}

		userRepository.save(user);

		return dto;
	}

	@Override
	public Restaurant updateRestaurantStatus(Long id) throws Exception {

		Restaurant restaurant = findRestaurantById(id);
		restaurant.setOpen(!restaurant.isOpen());
		return restaurantRepository.save(restaurant);
	}

}
