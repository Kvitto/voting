package ru.javapractice.voting.model;

import java.time.LocalDateTime;

public class Restaurant {

    private Long id;
    private String name;
    private String email;
    private Integer phone;
    private LocalDateTime registered;
    private boolean enabled;

    public Restaurant() {
    }

    public Restaurant(String name, String email, Integer phone, LocalDateTime registered, boolean enabled) {
        id = null;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.registered = registered;
        this.enabled = enabled;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isNew() {
        return this.id == null;
    }

}
