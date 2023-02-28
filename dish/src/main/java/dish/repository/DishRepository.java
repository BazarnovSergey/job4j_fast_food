package dish.repository;

import domain.model.Dish;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends CrudRepository<Dish, Integer> {

    @NonNull
    List<Dish> findAll();

}
