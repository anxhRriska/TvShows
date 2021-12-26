package com.betaplan.tvshows_belt_exam.repositories;

import com.betaplan.tvshows_belt_exam.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

   public Rating findRatingByShow_IdAndRaties_Id(Long showId,Long userId);

}
