package collar.data;

import org.springframework.data.repository.CrudRepository;

import collar.Collar;

public interface TacoRepository 
         extends CrudRepository<Collar, Long> {

}
