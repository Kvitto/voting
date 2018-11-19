package ru.javapractice.voting.service;

import javassist.NotFoundException;
import ru.javapractice.voting.model.User;

import java.util.List;

public interface UserService {

    void delete(int id) throws NotFoundException;

    void update(User user) throws NotFoundException;

    User create(User user);

    User get(int id) throws NotFoundException;

    List<User> getAll();

    User getByEmail(String email);

//    User getWithVotes(int id);
}
