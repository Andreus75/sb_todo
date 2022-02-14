package ua.com.andriy.sb_todo.services.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.andriy.sb_todo.dao.UserDao;
import ua.com.andriy.sb_todo.entity.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User saveUser(User user) {
        userDao.save(user);
        return user;
    }

    public Optional<User> findUserById(int user_id) {
        Optional<User> user = userDao.findById(user_id);
        return user;
    }

    public List<User> findAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }

    public void deleteUserById(int user_id) {
        userDao.deleteById(user_id);
    }
}
