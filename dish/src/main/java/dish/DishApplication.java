package dish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "domain.model")
@SpringBootApplication
public class DishApplication {
    public static void main(String[] args) {
        SpringApplication.run(DishApplication.class, args);
    }
}
