package ua.com.andriy.sb_todo.services.todoService;

import ua.com.andriy.sb_todo.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    void saveTodo(Todo todo);
    Optional<Todo> findTodoById(int todo_id);
    List<Todo> findAllTodo();
    void deleteTodoById(int todo_id);
}
