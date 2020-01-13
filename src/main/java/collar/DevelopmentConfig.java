package collar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import collar.Ingredient.Type;
import collar.data.ComponentsRepository;
import collar.data.UserRepository;

@Profile("!prod")
@Configuration
public class DevelopmentConfig {

  @Bean
  public CommandLineRunner dataLoader(ComponentsRepository repo,
        UserRepository userRepo, PasswordEncoder encoder) { // user repo for ease of testing with a built-in user
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        repo.save(new Ingredient("LTHER", "Leather", Type.MATERIAL));
        repo.save(new Ingredient("PLETHER", "Pleather", Type.MATERIAL));
        
        repo.save(new Ingredient("SMALL", "Small(19cm - 28cm)", Type.SIZE));
        repo.save(new Ingredient("MEDIUM", "Medium(29cm - 39cm)", Type.SIZE));
        repo.save(new Ingredient("LARGE", "Large(40cm - 50cm)", Type.SIZE));
        
        
        
        repo.save(new Ingredient("STRPES", "Stripes", Type.PATTERN));
        repo.save(new Ingredient("DOTS", "Dots", Type.PATTERN));
        
        repo.save(new Ingredient("BRWN", "Brown", Type.COLOUR));
        repo.save(new Ingredient("BLCK", "Black", Type.COLOUR));
        
        repo.save(new Ingredient("ORNGE", "Orange", Type.PATTERN_COLOUR));
        repo.save(new Ingredient("GRN", "Green", Type.PATTERN_COLOUR));
        repo.save(new Ingredient("RED", "Red", Type.PATTERN_COLOUR));
        repo.save(new Ingredient("BLUE", "Blue", Type.PATTERN_COLOUR));
        
        
        userRepo.save(new User("admin", encoder.encode("admin"), 
            "John Doe", "123 Katherine Street", "Sandton", "JHB", 
            "1202", "060-887-8989"));
      }
    };
  }
  
}
