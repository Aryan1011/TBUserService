package com.ticketbooking.userService.services;

import com.ticketbooking.userService.entities.User;

public interface UserService {
    User createUser(User user);

    User findById(String id);
}
