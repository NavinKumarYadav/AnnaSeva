package com.annaseva.service;

import java.util.List;

import com.annaseva.model.IngredientCategory;
import com.annaseva.model.IngredientsItem;

public interface IngredientsService {

	public IngredientCategory creatrIngredientCategory(String name, Long restaurantId) throws Exception;

	public IngredientCategory findIngredientCategoryById(Long id) throws Exception;

	public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;

	public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId)
			throws Exception;

	public List<IngredientsItem> findRestaurantIngredients(Long restaurantId) throws Exception;

	public IngredientsItem updateStock(Long id) throws Exception;
}
