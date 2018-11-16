package ru.javapractice.voting.service.Impl;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javapractice.voting.model.User;
import ru.javapractice.voting.repository.Impl.UserRepositoryImpl;
import ru.javapractice.voting.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepositoryImpl userRepository;
    @Autowired
    public void setUserRepository(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public void update(User user) throws NotFoundException {
        userRepository.save(user);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(int id) {
        return userRepository.get(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }
}
