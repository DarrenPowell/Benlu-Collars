package collar.data;

import org.springframework.data.repository.CrudRepository;

import collar.Ingredient;

public interface ComponentsRepository 
         extends CrudRepository<Ingredient, String> {

}
