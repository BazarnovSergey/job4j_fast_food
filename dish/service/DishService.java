package service;

import src.main.java.domain.model.Dish;

import java.util.List;
import java.util.Optional;

/**
 * сервис блюд
 */
public interface DishService {

    Optional<Dish> addDish(Dish dish);

    List<Dish> findAll();

    Optional<Dish> findById(int id);

    Dish update(Dish dish);

    void delete(Dish dish);

}
