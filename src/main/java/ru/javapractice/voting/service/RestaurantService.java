package ru.javapractice.voting.service;

import javassist.NotFoundException;
import ru.javapractice.voting.model.Meal;
import ru.javapractice.voting.model.Restaurant;

import java.time.LocalDateTime;
import java.util.List;

public interface RestaurantService {

    void delete(int id) throws NotFoundException;

    void update(Restaurant restaurant) throws NotFoundException;

    Restaurant create(Restaurant restaurant);

    Restaurant get(int id) throws NotFoundException;

    List<Restaurant> findAll();

    Restaurant getByEmail(String email);

    List<Restaurant> getAllWithMealForDay(LocalDateTime date);
}
