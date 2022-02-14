package ua.com.andriy.sb_todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.com.andriy.sb_todo.entity.User;
import ua.com.andriy.sb_todo.services.userService.UserService;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Controller
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User newUser = userService.saveUser(user);

            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>((User) null, INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/users")
    public List<User> getUsers () {
        List<User> users = userService.findAllUsers();
        return users;
    }

    @GetMapping("/users/user_id")
    public Optional<User> getUserById (int user_id) {
        Optional<User> user = userService.findUserById(user_id);
        return user;
    }

    @DeleteMapping("/users/user_id")
    public void deleteUserById (int user_id) {
        userService.deleteUserById(user_id);
    }
}
