package ru.javapractice.voting.repository;

import ru.javapractice.voting.model.Vote;

import java.util.List;

public interface VoteRepository {
    //save
    Vote save(Vote vote);
    //delete
    boolean delete(Long id);
    //get
    Vote get(Long id);
    //get All for restaurant
    List<Vote> getAllRestaurantVote(Long restaurantId);
    //get All for user
    List<Vote> getAllUserVote(Long userId);
    //get All Vote
    List<Vote> getAll();
}
