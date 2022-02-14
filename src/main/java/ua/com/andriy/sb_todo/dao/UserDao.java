package ua.com.andriy.sb_todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.andriy.sb_todo.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
}
