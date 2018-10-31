package ru.javapractice.voting.repository.mock;

import ru.javapractice.voting.model.Restaurant;
import ru.javapractice.voting.repository.RestaurantRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRestaurantRepositoryImpl implements RestaurantRepository {

    private Map<Integer, Restaurant> repository = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @Override
    public Restaurant save(Restaurant restaurant) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Restaurant get(Long id) {
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }
}
