package ru.javapractice.voting.repository;

import ru.javapractice.voting.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    //save
    Restaurant save(Restaurant restaurant);
    //delete
    boolean delete(Long id);
    //get
    Restaurant get(Long id);
    //getAll
    List<Restaurant> getAll();
}
