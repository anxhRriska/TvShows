package com.betaplan.tvshows_belt_exam.services;

import com.betaplan.tvshows_belt_exam.models.Show;
import com.betaplan.tvshows_belt_exam.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public void updateOrCreate(Show show){
        showRepository.save(show);
    }
    public Show findShow(Long id){
        return showRepository.findShowById(id);
    }
    public List<Show> findAllShows(){
        return showRepository.findAll();
    }
    public void deleteShow(Long id){
        showRepository.deleteById(id);
    }

}
