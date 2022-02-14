package ua.com.andriy.sb_todo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id", nullable = false)
    @Getter
    @Setter
    private int todo_id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "time_of_creation")
    @Getter
    @Setter
    private String timeOfCreation;

    @Column(name = "status")
    @Getter
    @Setter
    private Status status;

    @Getter
    @Setter
    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    public Todo() {
    }

    public Todo(int todo_id, String name, String timeOfCreation, Status status) {
        this.todo_id = todo_id;
        this.name = name;
        this.timeOfCreation = timeOfCreation;
        this.status = status;
    }

    public Todo(int todo_id, String name, String timeOfCreation, Status status, User user) {
        this.todo_id = todo_id;
        this.name = name;
        this.timeOfCreation = timeOfCreation;
        this.status = status;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todo_id=" + todo_id +
                ", name='" + name + '\'' +
                ", timeOfCreation='" + timeOfCreation + '\'' +
                ", status=" + status +
                '}';
    }
}
