package com.annaseva.request;

import java.util.List;

import com.annaseva.model.Category;
import com.annaseva.model.IngredientsItem;

import lombok.Data;

@Data
public class CreateFoodRequest {

	private String name;
	private String description;
	private Long price;

	private Category category;
	private List<String> images;

	private Long restaurantId;
	private boolean vegetarian;
	private boolean seasional;
	private List<IngredientsItem> ingredients;

}
