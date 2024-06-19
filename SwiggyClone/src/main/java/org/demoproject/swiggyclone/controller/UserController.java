package org.demoproject.swiggyclone.controller;

import org.demoproject.swiggyclone.entity.User;
import org.demoproject.swiggyclone.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
   @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
   }
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteById(userId);
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
        User authenticatedUser = userService.authenticate(username, password);

        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

}
