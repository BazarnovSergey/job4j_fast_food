package dish.service;

import domain.model.Dish;

import java.util.List;
import java.util.Optional;

/**
 * сервис блюд
 */
public interface DishService {

    Dish addDish(Dish dish);

    List<Dish> findAll();

    Optional<Dish> findById(int id);

    boolean update(int id, Dish dish);

    boolean delete(int id);

}
