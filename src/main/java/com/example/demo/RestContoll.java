package com.example.demo;

import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.User;

import java.util.Optional;

@RestController
public class RestContoll {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(String login, Long id) {

        if(login != null){
            User user = userRepository.findByLogin(login);
            return user;
        }
        if (id != null) {
            Optional<User> user = userRepository.findById(id);
            return user.orElse(null);
        }
        return null;
    }
    @GetMapping("/user/{user}")
    public String user(@PathVariable String user){
        User user1 = userRepository.findByLogin(user);
        if (user1 != null){
            return user1.toString();
        }
        return "LOX";
    }
}
