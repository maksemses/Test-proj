package com.example.demo.services;

import com.example.demo.Mappers.UserMapper;
import com.example.demo.Model.User;
import com.example.demo.Model.UserRegister;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterService {

    final private UserMapper userMapper;
    final private UserRepository userRepository;

    public void save(UserRegister userRegister) {
        User user = userValidate(userRegister);
        if (user != null) {
            userRepository.save(user);
        }
        else{
            System.out.println("Not Valid");
        }
    }

    User userValidate(UserRegister userRegister){
        if(isPasswordValidate(userRegister.getPassword(), userRegister.getConfirmPassword())){
            User user = userMapper.MappedToUser(userRegister);
            return user;
        }
        return null;
    }
    boolean isPasswordValidate(String password, String confirmPassword){
        if(password.equals(confirmPassword)){
            return true;
        }
        return false;
    }
}
