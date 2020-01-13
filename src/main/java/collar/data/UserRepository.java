package collar.data;
import org.springframework.data.repository.CrudRepository;

import collar.User;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
  
}
