package dish.service;

import dish.repository.DishRepository;
import domain.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleDishService implements DishService {

    private final DishRepository dishRepository;

    @Autowired
    public SimpleDishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findById(int id) {
        return dishRepository.findById(id);
    }

    @Override
    public boolean update(int id, Dish dish) {
        boolean rsl = false;
        Optional<Dish> optionalDish = dishRepository.findById(id);
        if (optionalDish.isPresent()) {
            dish.setId(id);
            dishRepository.save(dish);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        dishRepository.deleteById(id);
        return true;
    }
}
