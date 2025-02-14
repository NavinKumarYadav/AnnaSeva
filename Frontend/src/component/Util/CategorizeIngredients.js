export const categorizeIngredients = (ingredients) => {
  return ingredients.reduce((acc, ingredient) => {
    const { category } = ingredient;
    if (!acc[category.ingredient]) {
      acc[category.name] = [];
    }
    acc[category.name].push(ingredient);
    return acc;
  }, {});
};
