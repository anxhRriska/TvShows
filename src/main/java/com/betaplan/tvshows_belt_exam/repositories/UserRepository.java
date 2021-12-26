package com.betaplan.tvshows_belt_exam.repositories;

import com.betaplan.tvshows_belt_exam.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findUserById(Long userId);
}
