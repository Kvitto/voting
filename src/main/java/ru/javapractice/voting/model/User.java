package ru.javapractice.voting.model;

import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class User {

    private Long id;
    private String name;
    private String email;
    private Integer phone;
    private String password;
    private LocalDateTime registered;
    private boolean enabled;
    private Set<Role> role;

    protected User(){}

    public User(String name, String email, Integer phone, String password, LocalDateTime registered, boolean enabled, Set<Role> role) {
        id = null;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.registered = registered;
        this.enabled = enabled;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Collection<Role> role) {
        this.role = CollectionUtils.isEmpty(role)? Collections.emptySet() : EnumSet.copyOf(role);
    }

    public boolean isNew() {
        return this.id == null;
    }
}
