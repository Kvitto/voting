package ru.javapractice.voting;

import javassist.NotFoundException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javapractice.voting.model.Meal;
import ru.javapractice.voting.model.Restaurant;
import ru.javapractice.voting.repository.CrudMealRepository;
import ru.javapractice.voting.repository.CrudRestaurantRepository;
import ru.javapractice.voting.repository.Impl.MealRepositoryImpl;
import ru.javapractice.voting.repository.Impl.RestaurantRepositoryImpl;
import ru.javapractice.voting.service.Impl.MealServiceImpl;
import ru.javapractice.voting.service.Impl.RestaurantServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


            MealServiceImpl mealService = context.getBean(MealServiceImpl.class);
            RestaurantServiceImpl restaurantService = context.getBean(RestaurantServiceImpl.class);

            System.out.println(mealService.get(100007));
            mealService.getAllForRest(100002).forEach(System.out::println);
            mealService.getAllForRestInDate(100003, LocalDate.of(2018, 11, 15)).forEach(System.out::println);
            System.out.println(mealService.getByIdForRest(100005, 100002));

            Restaurant restaurant = restaurantService.get(100003);
            Meal meal = new Meal("Mockito", 1.0);
            meal.setRestaurant(restaurant);
            System.out.println(mealService.create(meal, restaurant.getId()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
