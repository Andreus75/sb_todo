package ua.com.andriy.sb_todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.andriy.sb_todo.entity.Todo;
import ua.com.andriy.sb_todo.services.todoService.TodoService;

import java.util.List;
import java.util.Optional;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/todo")
    public Todo createTodo (Todo todo) {
        todoService.saveTodo(todo);
        return todo;
    }

    @GetMapping("/todo")
    public List<Todo> getAllTodo () {
        List<Todo> allTodo = todoService.findAllTodo();
        return allTodo;
    }

    @GetMapping("/todo/todo_id")
    public Optional<Todo> getTodoById (int todo_id) {
        Optional<Todo> todo = todoService.findTodoById(todo_id);
        return todo;
    }

    @DeleteMapping("/todo/todo_id")
    public void deleteTodoById (int todo_id) {
        todoService.deleteTodoById(todo_id);
    }


}
