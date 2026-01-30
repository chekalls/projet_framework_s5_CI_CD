package com.example.frontend.service;

import com.example.frontend.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    
    private List<User> users = new ArrayList<>();
    
    public UserService() {
        // Données d'exemple
        users.add(new User(1L, "John Doe", "john@example.com"));
        users.add(new User(2L, "Jane Smith", "jane@example.com"));
    }
    
    public List<User> getAllUsers() {
        return users;
    }
    
    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public User createUser(User user) {
        users.add(user);
        return user;
    }
}
