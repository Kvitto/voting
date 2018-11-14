package ru.javapractice.voting.repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javapractice.voting.model.Meal;
import ru.javapractice.voting.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class MealRepositoryImpl {
    @Autowired
    private MealRepository repository;

    public Meal save(Meal meal) {
        return repository.save(meal);
    }

    public boolean delete(int id, int user_id) {
        return repository.delete(id, user_id)!=0;
    }

    public Optional<Meal> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Meal> getAll(int restaurantId){
        return repository.getAll(restaurantId);
    }

    public List<Meal> getByRegistered(int restaurant_id, LocalDateTime date){
        return repository.getByRegistered(restaurant_id, date);
    }

    public Meal getByIdWithRestaurant(int id, int restaurant_id){
        return repository.getByIdWithRestaurant(id, restaurant_id);
    }
}
