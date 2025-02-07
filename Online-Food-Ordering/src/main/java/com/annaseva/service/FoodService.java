package com.annaseva.service;

import java.util.List;

import com.annaseva.model.Category;
import com.annaseva.model.Food;
import com.annaseva.model.Restaurant;
import com.annaseva.request.CreateFoodRequest;

public interface FoodService {
	public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

	void deleteFood(Long foodId) throws Exception;

	public List<Food> getRestaurantsFood(Long restaurantId, boolean isVegitarain, boolean isNonveg, boolean isSeasonal,
			String foodCategory);

	public List<Food> searchFood(String keyword);

	public Food findFoodById(Long foodId) throws Exception;

	public Food updateAvailibityStatus(Long foodId) throws Exception;
}
