package ru.javapractice.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javapractice.voting.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface MealRepository extends JpaRepository<Meal, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Meal m WHERE m.id=?1 AND m.restaurant.id=?2")
    int delete(int id, int restaurant_id);

    @Override
    @Transactional
    Meal save(Meal item);

    @Query("SELECT m FROM Meal m WHERE m.restaurant.id=?1")
    List<Meal> getAll(int restaurant_id);

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT m from Meal m WHERE m.restaurant.id=?1 AND m.registered>?2")
    List<Meal> getByRegistered(int restaurant_id, LocalDateTime date);

    @Query("SELECT m FROM Meal m JOIN FETCH m.restaurant WHERE m.id = ?1 and m.restaurant.id = ?2")
    Meal getByIdWithRestaurant(int id, int restaurant_id);
}

