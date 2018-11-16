package ru.javapractice.voting.repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javapractice.voting.model.Vote;
import ru.javapractice.voting.repository.CrudVoteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class VoteRepositoryImpl {
    @Autowired
    private CrudVoteRepository repository;

    public Vote save(Vote vote) {
        return repository.save(vote);
    }

    public boolean delete(int id, int user_id) {
        return repository.delete(id, user_id);
    }

    public Optional<Vote> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Vote> getAllRestaurantVote(int restaurantId) {
        return repository.getAllRestaurantVote(restaurantId);
    }

    public List<Vote> getAllUserVote(int userId) {
        return repository.getAllUserVote(userId);
    }

    public List<Vote> getAllByRegistered(LocalDateTime dateTime) {
        return repository.getAllByRegistered(dateTime);
    }
}
