package com.portfolio.my_stock_portfolio.service;

import com.portfolio.my_stock_portfolio.model.User;
import com.portfolio.my_stock_portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    // Constructor injection for UserRepository and PasswordService
    @Autowired
    public UserService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    // Register a new user with username, email, and plain password
    public User registerUser(String username, String email, String plainPassword) {
        // Hash the plain password before storing it
        String hashedPassword = passwordService.hashPassword(plainPassword);

        // Create a new User object
        User newUser = new User(username, email, hashedPassword);

        // Save the user to the repository (database)
        return userRepository.save(newUser);
    }

    // Validate a user's login credentials (email and password)
    public boolean authenticateUser(String email, String plainPassword) {
        // Find the user by their email
        User user = userRepository.findByEmail(email);

        // Check if the user exists and if the password matches
        if (user != null) {
            return passwordService.matchPassword(plainPassword, user.getPasswordHash());
        }

        // Return false if user not found or password does not match
        return false;
    }
}
