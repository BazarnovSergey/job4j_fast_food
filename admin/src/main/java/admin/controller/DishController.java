package admin.controller;

import admin.service.DishService;
import domain.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/")
    public String allDishes(Model model) {
        model.addAttribute("allDishes", dishService.findAll());
        return "dish/dishes";
    }

    @PostMapping("/createDish")
    public String createDish(@ModelAttribute("dish") Dish dish
    ) {
        dishService.addDish(dish);
        return "redirect:/";
    }

    @GetMapping("/formAddDish")
    public String formAddDish(Model model) {
        model.addAttribute("dish", new Dish());
        return "dish/addNewDish";
    }

    @GetMapping("/dish/{dishId}")
    public String dish(Model model, @PathVariable("dishId") int id) {
        Optional<Dish> optionalDish = dishService.findById(id);
        if (optionalDish.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("dish", optionalDish.get());
        return "dish/dish";
    }

    @PostMapping("/updateDish")
    public String edit(@ModelAttribute Dish dish) {
        dishService.update(dish.getId(), dish);
        return "redirect:/";
    }

    @GetMapping("/{id}/formUpdateDish")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("dish", dishService.findById(id));
        return "dish/formUpdateDish";
    }

    @PostMapping("/{id}/removeDish")
    public String remove(@PathVariable("id") int id) {
        dishService.delete(id);
        return "redirect:/";
    }

}
