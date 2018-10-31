package ru.javapractice.voting.repository;

import ru.javapractice.voting.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepository {
    //
    Meal save(Meal meal);
    //
    void delete(Long id);
    //
    Meal get(Long id);
    // Get all meal for restaurant
    List<Meal> getAllRestaurantMeal(Long restaurantId);
    // Get all meal
    List<Meal> getAll();
}
