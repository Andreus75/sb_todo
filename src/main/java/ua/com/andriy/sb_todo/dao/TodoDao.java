package ua.com.andriy.sb_todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.andriy.sb_todo.entity.Todo;

public interface TodoDao extends JpaRepository<Todo, Integer> {
}
