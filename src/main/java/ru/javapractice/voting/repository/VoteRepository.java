package ru.javapractice.voting.repository;

import ru.javapractice.voting.model.Vote;

import java.util.List;

public interface VoteRepository {
    //save
    Vote save(Vote vote);
    //delete
    boolean delete(int id);
    //get
    Vote get(int id);
    //get All for restaurant
    List<Vote> getAllRestaurantVote(int restaurantId);
    //get All for user
    List<Vote> getAllUserVote(int userId);
    //get All Vote
    List<Vote> getAll();
}
