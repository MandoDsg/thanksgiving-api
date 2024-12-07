package com.mandodsg.thanksgiving_api.repository;

import com.mandodsg.thanksgiving_api.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
