package com.vaishnavi.practice.servlet.service;

import com.vaishnavi.practice.servlet.model.User;
import com.vaishnavi.practice.servlet.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    // Authenticate user
    public User authenticateUser(String email, String password) {
        User user = userRepository.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // Deposit money
    public boolean depositMoney(User user, double amount) {
        if (amount > 0) {
            user.setBalance(user.getBalance() + amount);
            userRepository.updateBalance(user);
            return true;
        }
        return false;
    }

    // Withdraw money
    public boolean withdrawMoney(User user, double amount) {
        if (amount > 0 && user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            userRepository.updateBalance(user);
            return true;
        }
        return false;
    }
}



