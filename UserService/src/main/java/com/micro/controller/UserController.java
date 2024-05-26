package com.micro.controller;

import com.micro.entities.User;
import com.micro.servuces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saveNewUser=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(saveNewUser);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long id) {
        User user=userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList=userService.getAllUser();
        return ResponseEntity.ok(userList);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable Long id) {
        User updateNew=userService.updateUserById(user,id);
        return ResponseEntity.ok(updateNew);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
