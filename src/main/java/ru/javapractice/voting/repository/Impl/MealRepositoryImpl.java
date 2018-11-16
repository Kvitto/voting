package ru.javapractice.voting.repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javapractice.voting.model.Meal;
import ru.javapractice.voting.repository.CrudMealRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MealRepositoryImpl {
    @Autowired
    private CrudMealRepository repository;


    public Meal save(Meal meal) {
        return repository.save(meal);
    }

    //OK
    public boolean delete(int id, int restaurantId) {
        return repository.delete(id, restaurantId)!=0;
    }

    //OK
    public Optional<Meal> findById(Integer id) {
        return repository.findById(id);
    }

    //OK
    public List<Meal> getAllByRestaurant(int restaurantId){
        return repository.getAllByRestaurant(restaurantId);
    }

    //OK
    public List<Meal> getAllByRestaurantAndRegistered(int restaurant_id, LocalDate date){
        return repository.getAllByRestaurantAndRegistered(restaurant_id, date);
    }

    //OK
    public Meal getByIdWithRestaurant(int id, int restaurant_id){
        return repository.getByIdWithRestaurant(id, restaurant_id);
    }
}
