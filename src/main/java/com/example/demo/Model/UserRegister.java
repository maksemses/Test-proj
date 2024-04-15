package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserRegister {
    private String login;
    private String password;
    private String confirmPassword;
}
