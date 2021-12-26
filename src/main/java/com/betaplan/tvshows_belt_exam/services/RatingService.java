package com.betaplan.tvshows_belt_exam.services;

import com.betaplan.tvshows_belt_exam.models.Rating;
import com.betaplan.tvshows_belt_exam.models.Show;
import com.betaplan.tvshows_belt_exam.models.User;
import com.betaplan.tvshows_belt_exam.repositories.RatingRepository;
import com.betaplan.tvshows_belt_exam.repositories.ShowRepository;
import com.betaplan.tvshows_belt_exam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private UserRepository userRepository;

    public void createRating(Long showId, Long userId){
        Show show=showRepository.findShowById(showId);
        User user=userRepository.findUserById(userId);
        Rating rating =new Rating(user, show);
        ratingRepository.save(rating);
    }
    private void deleteRating(Long ratingId){
        ratingRepository.deleteById(ratingId);
    }
    public Rating findRating(Long showId, Long userId){
        return ratingRepository.findRatingByShow_IdAndRaties_Id(showId,userId);
    }
}
