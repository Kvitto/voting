package ru.javapractice.voting.service;

import javassist.NotFoundException;
import ru.javapractice.voting.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface MealService {

    Meal get(int id/*, int rest_id*/) throws NotFoundException;

    void delete(int id, int rest_id) throws NotFoundException;

    List<Meal> getAllForRestInDate(int rest_id, LocalDate date);

    List<Meal> getAllForRest(int rest_id);

    void update(Meal meal, int rest_id) throws NotFoundException;

    Meal create(Meal meal, int rest_id);

    Meal getByIdForRest(int id, int rest_id);
}
