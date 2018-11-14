package ru.javapractice.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javapractice.voting.model.Vote;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Override
    @Transactional
    Vote save(Vote vote);

    @Modifying
    @Transactional
    @Query("DELETE FROM Vote v WHERE v.id=?1 AND v.user.id=?2")
    boolean delete(int id, int user_id);
    //get
    Optional<Vote> findById(Integer id);

    //get All for restaurant
    @Query("SELECT v FROM Vote v WHERE v.restaurant.id=?1")
    List<Vote> getAllRestaurantVote(int restaurantId);

    //get All for user
    @Query("SELECT v FROM Vote v WHERE v.user.id=?1")
    List<Vote> getAllUserVote(int userId);

    //get All Vote for Date
    @Query("SELECT v FROM Vote v WHERE v.registered=?1")
    List<Vote> getAllByRegistered(LocalDateTime dateTime);
}
