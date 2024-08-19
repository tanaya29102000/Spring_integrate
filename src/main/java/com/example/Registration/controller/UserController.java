package com.example.Registration.controller;

import com.example.Registration.model.User;
import com.example.Registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000") // Replace with your React app URL
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<List<User>> registerUser(@RequestBody User user) {
        userService.saveUser(user);
        return getUserData(); // Now returns ResponseEntity<List<User>>
    }

    @GetMapping("/userData")
    public ResponseEntity<List<User>> getUserData() {
        List<User> users = userService.findAll(); // Assuming findAll() returns a List of User
        return ResponseEntity.ok(users);
    }

    // Define a ResponseMessage class to encapsulate the message
    public static class ResponseMessage {
        private String message;

        public ResponseMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
