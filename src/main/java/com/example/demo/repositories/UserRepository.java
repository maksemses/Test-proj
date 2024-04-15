package com.example.demo.repositories;

import com.example.demo.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
}
