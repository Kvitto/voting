package ru.javapractice.voting.service.Impl;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javapractice.voting.model.Vote;
import ru.javapractice.voting.repository.Impl.VoteRepositoryImpl;
import ru.javapractice.voting.service.VoteService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
     private VoteRepositoryImpl voteRepository;
     @Autowired
     public void setVoteRepository(VoteRepositoryImpl voteRepository) {
         this.voteRepository = voteRepository;
     }

     @Override
    public void update(Vote vote) throws NotFoundException {
        voteRepository.save(vote);
    }

    @Override
    public Vote create(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public void delete(int id, int user_id) {
        voteRepository.delete(id, user_id);
    }

    @Override
    public Vote get(int id) {
        return voteRepository.get(id);
    }

    @Override
    public List<Vote> getAllRestaurantVote(int restaurantId) {
        return voteRepository.getAllRestaurantVote(restaurantId);
    }

    @Override
    public List<Vote> getAllUserVote(int userId) {
        return voteRepository.getAllUserVote(userId);
    }

    @Override
    public List<Vote> getAllByRegistered(LocalDateTime dateTime) {
        return voteRepository.getAllByRegistered(dateTime);
    }
}
