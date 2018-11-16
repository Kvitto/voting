package ru.javapractice.voting.service.Impl;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javapractice.voting.model.Meal;
import ru.javapractice.voting.repository.CrudMealRepository;
import ru.javapractice.voting.service.MealService;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class MealServiceImpl implements MealService {
    @Autowired
    CrudMealRepository repository;

    @Override
    public Meal get(int id/*, int rest_id*/) throws NotFoundException {
        return repository.getOne(id);
    }

    @Override
    public void delete(int id, int rest_id) throws NotFoundException {
        repository.delete(repository.getOne(id));
    }

    @Override
    public List<Meal> getAllForRestInDate(int rest_id, LocalDate date) {
        return repository.getAllByRestaurantAndRegistered(rest_id, date);
    }

    @Override
    public List<Meal> getAllForRest(int rest_id) {
        return repository.getAllByRestaurant(rest_id);
    }

    @Override
    public void update(Meal meal, int rest_id) throws NotFoundException {
        repository.save(meal);
    }

    @Override
    public Meal create(Meal meal, int rest_id) {
        return repository.save(meal);
    }

    @Override
    public Meal getWithRest(int id, int rest_id) {
        return repository.getByIdWithRestaurant(id, rest_id);
    }
}
