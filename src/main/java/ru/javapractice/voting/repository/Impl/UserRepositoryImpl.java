package ru.javapractice.voting.repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javapractice.voting.model.User;
import ru.javapractice.voting.repository.CrudUserRepository;

import java.util.List;

@Repository
public class UserRepositoryImpl {
    private static final Sort SORT_NAME_EMAIL = new Sort(Sort.Direction.ASC, "name", "email");
    @Autowired
    private CrudUserRepository repository;

    public boolean delete(int id){
        return repository.delete(id)!=0;
    }

    public User save(User user){
        return repository.save(user);
    }

    public User get(int id){
        return repository.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return repository.findAll(SORT_NAME_EMAIL);
    }

    public User getByEmail(String email){
        return repository.getByEmail(email);
    }

    public User getWithMeals(int id){
        return repository.getWithMeals(id);
    }
}
