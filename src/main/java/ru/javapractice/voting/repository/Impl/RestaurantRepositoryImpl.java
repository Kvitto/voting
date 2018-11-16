package ru.javapractice.voting.repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javapractice.voting.model.Restaurant;
import ru.javapractice.voting.repository.CrudRestaurantRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl {
    private static final Sort SORT_NAME_EMAIL = new Sort(Sort.Direction.ASC, "name", "email");
    @Autowired
    private CrudRestaurantRepository repository;

    public boolean delete(Integer id){
        return repository.delete(id);
    }

    public Restaurant save(Restaurant restaurant){
        return repository.save(restaurant);
    }

    public Restaurant get(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Restaurant> findAll(){
        return repository.findAll(SORT_NAME_EMAIL);
    }

    public Restaurant getByEmail(String email){
        return repository.getByEmail(email);
    }

    public List<Restaurant> getAllWithMealForDay(LocalDateTime date){
        return repository.getAllWithMealForDay(date);
    }

    public Restaurant getWithMeals(int id, LocalDateTime date){
        return repository.getWithMealsForDay(id, date);
    }
}
