package ru.javapractice.voting.repository.mock;

import ru.javapractice.voting.model.Vote;
import ru.javapractice.voting.repository.VoteRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryVoteRepositoryImpl implements VoteRepository {

    private Map<Integer, Vote> repository = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @Override
    public Vote save(Vote vote) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Vote get(Long id) {
        return null;
    }

    @Override
    public List<Vote> getAllRestaurantVote(Long restaurantId) {
        return null;
    }

    @Override
    public List<Vote> getAllUserVote(Long userId) {
        return null;
    }

    @Override
    public List<Vote> getAll() {
        return null;
    }
}
