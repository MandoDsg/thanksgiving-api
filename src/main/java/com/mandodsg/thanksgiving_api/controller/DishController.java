package com.mandodsg.thanksgiving_api.controller;

import com.mandodsg.thanksgiving_api.model.Dish;
import com.mandodsg.thanksgiving_api.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @PostMapping
    public Dish createDish(@RequestBody Dish dish) {
        return dishService.saveDish(dish);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dish> uptadateDish(@PathVariable Long id, @RequestBody Dish dish) {
        return dishService.getDishById(id).map(existingDish -> {
            existingDish.setDishName(dish.getDishName());
            existingDish.setDishType(dish.getDishType());
            existingDish.setCookName(dish.getCookName());
            return ResponseEntity.ok(dishService.saveDish(existingDish));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }
}
