package ru.javapractice.voting.model;

import java.time.LocalDateTime;

public class Vote {

    private Long id;
    private long userId;
    private long restaurantId;
    private LocalDateTime dateTime;

    public Vote() {
    }

    public Vote(long userId, long restaurantId, LocalDateTime dateTime) {
        id = null;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isNew() {
        return this.id == null;
    }

}
