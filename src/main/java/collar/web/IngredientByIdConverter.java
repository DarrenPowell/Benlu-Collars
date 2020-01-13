package collar.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import collar.Ingredient;
import collar.data.ComponentsRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

  private ComponentsRepository ingredientRepo;

  @Autowired
  public IngredientByIdConverter(ComponentsRepository ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }
  
  @Override
  public Ingredient convert(String id) {
    Optional<Ingredient> optionalIngredient = ingredientRepo.findById(id);
	return optionalIngredient.isPresent() ?
		   optionalIngredient.get() : null;
  }

}
