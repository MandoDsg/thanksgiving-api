package com.mandodsg.thanksgiving_api.service;

import com.mandodsg.thanksgiving_api.model.Dish;
import com.mandodsg.thanksgiving_api.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Dish saveDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Optional<Dish> getDishById(Long id) {
        return dishRepository.findById(id);
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}
