package com.micro.servuces;

import com.micro.entities.User;

import java.util.List;
import java.util.Objects;

public interface UserService {

    // create new User
    User saveUser(User user);

    // Get all users
    List<User> getAllUser();

    // get User by id
    User getUserById(Long id);

    // Update User by id
    User updateUserById(User user,Long id);

    // delete user by id
    void deleteUserById(Long id);
}
