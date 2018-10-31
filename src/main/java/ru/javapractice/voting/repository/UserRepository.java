package ru.javapractice.voting.repository;

import ru.javapractice.voting.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(Long id);

    // null if not found
    User get(Long id);

    List<User> getAll();

}
