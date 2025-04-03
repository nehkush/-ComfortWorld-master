package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Admin;
import com.app.model.Order;
import com.app.model.User;

public interface IUserService {

    // Create
    User createUser(User user);

    // Read
    Optional<User> getUserById(Long userId);

    List<User> getAllUsers();

    // Update
    User updateUser(Long userId, User updatedUser);

    // Delete
    void deleteUser(Long userId);
    
    

    User getUserByEmail(String email);
}
