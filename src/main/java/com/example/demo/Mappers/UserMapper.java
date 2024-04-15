package com.example.demo.Mappers;

import com.example.demo.Model.User;
import com.example.demo.Model.UserRegister;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User MappedToUser(UserRegister userRegister) {
        User user = new User();
        return user.setLogin(userRegister.getLogin()).setPassword(userRegister.getPassword());
    }
}
