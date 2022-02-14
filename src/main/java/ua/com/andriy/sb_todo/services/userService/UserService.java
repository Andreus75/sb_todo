package ua.com.andriy.sb_todo.services.userService;

import ua.com.andriy.sb_todo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);
    Optional<User> findUserById(int user_id);
    List<User> findAllUsers();
    void deleteUserById(int user_id);
}
