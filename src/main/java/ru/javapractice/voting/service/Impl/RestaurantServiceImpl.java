package ru.javapractice.voting.service.Impl;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javapractice.voting.model.Restaurant;
import ru.javapractice.voting.repository.Impl.RestaurantRepositoryImpl;
import ru.javapractice.voting.service.RestaurantService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepositoryImpl restaurantRepository;
    @Autowired
    public void setRestaurantRepository(RestaurantRepositoryImpl restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void delete(int id) {
        restaurantRepository.delete(id);
    }

    @Override
    public void update(Restaurant restaurant) throws NotFoundException {
        restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant get(int id) {
        return restaurantRepository.get(id);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getByEmail(String email) {
        return restaurantRepository.getByEmail(email);
    }

    @Override
    public List<Restaurant> getAllWithMealForDay(LocalDateTime date) {
        return restaurantRepository.getAllWithMealForDay(date);
    }
}
