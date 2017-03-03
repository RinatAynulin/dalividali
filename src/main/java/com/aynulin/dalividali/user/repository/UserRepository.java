package com.aynulin.dalividali.user.repository;

/**
 * Created by Aynulin on 30.01.2017.
 */
import com.aynulin.dalividali.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}