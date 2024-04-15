package com.example.demo.Controllers;

import com.example.demo.Model.User;
import com.example.demo.Model.UserRegister;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final UserRepository userRepository;
    private final UserRegisterService userRegisterService;
    @GetMapping("/users")
    public String index(Model model) {
        List<User> users = (List<User>) userRepository.findAll();
        if (users != null){
            model.addAttribute("users", users);
        }
        return "users";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        UserRegister userRegister = new UserRegister();
        model.addAttribute("userRegister", userRegister);
        return "register_form";
    }
    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") UserRegister user) {
        userRegisterService.save(user);
        return "register_success";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
    @PostMapping("/login")
    public String submitLoginForm(@ModelAttribute("user") User user) {
        User user1= userRepository.findByLogin(user.getLogin());
        if (user1 != null){
            return "users";
        }
        return "login_successNO";
    }
}
