package ua.com.andriy.sb_todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.com.andriy.sb_todo.entity.Role;
import ua.com.andriy.sb_todo.entity.Status;
import ua.com.andriy.sb_todo.entity.Todo;
import ua.com.andriy.sb_todo.entity.User;
import ua.com.andriy.sb_todo.services.todoService.TodoService;
import ua.com.andriy.sb_todo.services.userService.UserService;

@SpringBootApplication
public class SbTodoApplication {

	@Autowired
	private UserService userService;
	@Autowired
	private TodoService todoService;

	public static void main(String[] args) {
		SpringApplication.run(SbTodoApplication.class, args);
	}

	@EventListener( ApplicationReadyEvent.class)
	private void testJpaMethods() {

		User user = new User();
		user.setUser_id(1);
		user.setUserName("Ivan");
		user.setEmail("Ivan@gmail.com");
		user.setPassword("ivan");
		user.setRole(Role.USER);
		System.out.println(user);
		userService.saveUser(user);

		Todo todo = new Todo();
		todo.setName("todo4");
		todo.setTimeOfCreation("11:10");
		todo.setStatus(Status.New);

		Todo todo1 = new Todo();
		todo1.setName("todo5");
		todo1.setTimeOfCreation("11:10");
		todo1.setStatus(Status.New);

		todoService.saveTodo(todo);
		todoService.saveTodo(todo1);
	}

}
