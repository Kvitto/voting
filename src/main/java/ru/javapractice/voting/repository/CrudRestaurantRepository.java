package ru.javapractice.voting.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javapractice.voting.model.Restaurant;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    boolean delete(@Param("id") int id);

    @Override
    @Transactional
    Restaurant save(Restaurant item);

    @Override
    Optional<Restaurant> findById(Integer id);

    @Override
    List<Restaurant> findAll(Sort sort);

    Restaurant getByEmail(String email);

    @Query("SELECT r FROM Restaurant r JOIN FETCH Meal m WHERE m.registered >: date")
    List<Restaurant> getAllWithMealForDay(@Param("date") LocalDateTime date);

    @EntityGraph(attributePaths = {"meals", "votes"})
    @Query("SELECT r FROM Restaurant r INNER JOIN Meal m ON m.restaurant.id = r.id WHERE r.id = :id AND m.registered > :date")
    Restaurant getWithMealsForDay(@Param("id")int id, @Param("date") LocalDateTime date);
}
