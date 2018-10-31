package ru.javapractice.voting.repository.mock;

import ru.javapractice.voting.model.Meal;
import ru.javapractice.voting.repository.MealRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryMealRepositoryImpl implements MealRepository {

    private Map<Long, Meal> repository = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @Override
    public Meal save(Meal meal) {
        if(meal.isNew()){
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
            return meal;
        }
        if(repository.get(meal.getId())!=null)
            return repository.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
        return null;
    }

    @Override
    public void delete(Long id) {
        if(repository.get(id)!=null) repository.remove(id);
    }

    @Override
    public Meal get(Long id) {
        Meal meal;
        if((meal = repository.get(id))!=null) return meal;
        return null;
    }

    @Override
    public List<Meal> getAllRestaurantMeal(Long restaurantId) {
        return repository.entrySet().stream()
                .filter(m -> m.getValue().getRestaurantId() == restaurantId)
                .map(Map.Entry::getValue)
                .sorted(Comparator.comparing(Meal::getRegistered).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<Meal>(repository.values());
    }
}
