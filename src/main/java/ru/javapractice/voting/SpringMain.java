package ru.javapractice.voting;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javapractice.voting.model.Meal;
import ru.javapractice.voting.model.Restaurant;
import ru.javapractice.voting.repository.CrudMealRepository;
import ru.javapractice.voting.repository.CrudRestaurantRepository;
import ru.javapractice.voting.repository.Impl.MealRepositoryImpl;
import ru.javapractice.voting.repository.Impl.RestaurantRepositoryImpl;

import java.time.LocalDate;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


        MealRepositoryImpl repository = context.getBean(MealRepositoryImpl.class);
        RestaurantRepositoryImpl restaurantRepository = context.getBean(RestaurantRepositoryImpl.class);

        System.out.println();
        System.out.println("findById(100007)");
        System.out.println(repository.findById(100007));

        System.out.println();
        System.out.println("getAllByRestaurant(100002)");
        repository.getAllByRestaurant(100002).forEach(System.out::println);

        System.out.println();
        System.out.println("getAllByRestaurantAndRegistered(100003, LocalDate.of(2018,11,15))");
        repository.getAllByRestaurantAndRegistered(100003, LocalDate.of(2018,11,15)).forEach(System.out::println);

        System.out.println();
        System.out.println("getByIdWithRestaurant(100005, 100002)");
        System.out.println(repository.getByIdWithRestaurant(100005, 100002));

        Restaurant restaurant = restaurantRepository.findById(100003).get();
        Meal meal = new Meal("Mokhito", 1.0);
        meal.setRestaurant(restaurant);
        System.out.println("save(new meal)");
        System.out.println(repository.save(meal));

        context.close();
    }
}
