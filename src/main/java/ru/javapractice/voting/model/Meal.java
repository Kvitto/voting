package ru.javapractice.voting.model;

import java.time.LocalDate;

public class Meal {

    private Long id;
    private String name;
    private double price;
    private LocalDate registered;
    private long restaurantId;

    public Meal() {
    }

    public Meal(String name, double price, LocalDate registered, long restaurantId) {
        id = null;
        this.name = name;
        this.price = price;
        this.registered = registered;
        this.restaurantId = restaurantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public boolean isNew() {
        return this.id == null;
    }

}
