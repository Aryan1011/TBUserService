package com.ticketbooking.userService.controller;

import com.ticketbooking.userService.entities.User;
import com.ticketbooking.userService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getById(@PathVariable String id){
        return ResponseEntity.ok(userService.findById(id));
    }
}
