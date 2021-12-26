package com.betaplan.tvshows_belt_exam.repositories;

import com.betaplan.tvshows_belt_exam.models.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {

    public Show findShowById(Long id);
    public List<Show> findAll();

}
