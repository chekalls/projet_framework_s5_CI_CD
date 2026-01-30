package com.example.frontend.controller;

import com.example.frontend.model.User;
import com.example.frontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/views")
public class ViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Bienvenue sur la page d'accueil");
        model.addAttribute("date", new java.util.Date());
        return "home";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/{id}")
    public String userDetails(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "user-details";
        }
        return "redirect:/views/users";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/form")
    public String submitForm(@RequestParam String name, 
                            @RequestParam String email, 
                            Model model) {
        User newUser = new User();
        newUser.setId((long) (userService.getAllUsers().size() + 1));
        newUser.setName(name);
        newUser.setEmail(email);
        userService.createUser(newUser);
        
        model.addAttribute("message", "Utilisateur créé avec succès!");
        return "redirect:/views/users";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("appName", "Frontend Spring Boot Application");
        model.addAttribute("version", "1.0.0");
        return "about";
    }
}
