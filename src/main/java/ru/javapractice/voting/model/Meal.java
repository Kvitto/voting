package ru.javapractice.voting.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "meals")
public class Meal extends AbstractBaseEntity {

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "registered", nullable = false)
    @NotNull
    private LocalDate registered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    public Meal() {
    }

    public Meal(Meal meal){
        this(meal.getId(), meal.getDescription(), meal.getPrice(), meal.getRegistered());
    }

    public Meal(String description, double price){
        this(null, description, price, LocalDate.now());
    }

    public Meal(Integer id, String description, double price, LocalDate registered) {
        super(id);
        this.description = description;
        this.price = price;
        this.registered = registered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "ID=" + id +
                ", Restaurant_Id=" + restaurant.getId() +
                ", registered=" + registered +
                ", description=" + description +
                ", price=" + price +
                '}';
    }
}
