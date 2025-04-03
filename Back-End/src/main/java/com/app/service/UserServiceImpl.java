package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Admin;
import com.app.model.Order;
import com.app.model.User;
import com.app.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        // Add any additional logic before saving the user, if needed
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        // Check if the user with the given ID exists
    	
        if (userRepository.existsById(userId)) {
            // Set the ID of the updatedUser to the existing user's ID
            updatedUser.setId(userId);
            return userRepository.save(updatedUser);
            
        } else {
            // Handle the case where the user with the given ID doesn't exist
            // You might want to throw an exception or handle it according to your application's needs
            return null;
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

	
	@Override
    public User getUserByEmail(String email) {
        User user=userRepository.findByEmail(email);
return user;   
    }

	

	
	

	
}
