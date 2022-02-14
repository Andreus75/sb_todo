package ua.com.andriy.sb_todo.services.todoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.andriy.sb_todo.dao.TodoDao;
import ua.com.andriy.sb_todo.entity.Todo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoDao todoDao;

    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    public void saveTodo(Todo todo) {
        todoDao.save(todo);
    }

    @Override
    public Optional<Todo> findTodoById(int todo_id) {
        Optional<Todo> todo = todoDao.findById(todo_id);
        return todo;
    }

    @Override
    public List<Todo> findAllTodo() {
        List<Todo> todos = todoDao.findAll();
        return todos;
    }

    @Override
    public void deleteTodoById(int todo_id) {
        todoDao.deleteById(todo_id);
    }
}
