package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "users")
@Data
@Component
@Accessors(chain = true)
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
    public User() {

    }
}
