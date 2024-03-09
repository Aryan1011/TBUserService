package com.ticketbooking.userService.services.impl;

import com.ticketbooking.userService.entities.User;
import com.ticketbooking.userService.repositories.UserRepository;
import com.ticketbooking.userService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("No user present with Id: "+id));
    }
}
