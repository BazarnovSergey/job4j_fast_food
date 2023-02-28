package admin.service;

import domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {

    Dish addDish(Dish dish);

    List<Dish> findAll();

    Optional<Dish> findById(int id);

    boolean update(int id, Dish dish);

    boolean delete(int id);

}