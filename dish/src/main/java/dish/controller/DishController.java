package dish.controller;

import dish.service.DishService;
import domain.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/getAll")
    public List<Dish> getAll() {
        return dishService.findAll();
    }

    @PostMapping
    public Dish save(@RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestParam int id, @RequestBody Dish dish) {
        boolean status = dishService.update(id, dish);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id) {
        boolean status = dishService.delete(id);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @GetMapping("/getById")
    public Optional<Dish> getById(@RequestParam int id) {
        return dishService.findById(id);
    }
}
