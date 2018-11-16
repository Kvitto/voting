package ru.javapractice.voting.service;

import javassist.NotFoundException;
import ru.javapractice.voting.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

public interface VoteService {

    void update(Vote vote) throws NotFoundException;

    Vote create(Vote vote);

    void delete(int id, int user_id) throws NotFoundException;

    Vote get(int id) throws NotFoundException;

    List<Vote> getAllRestaurantVote(int restaurantId);

    List<Vote> getAllUserVote(int userId);

    List<Vote> getAllByRegistered(LocalDateTime dateTime);
}
