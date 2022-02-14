package ua.com.andriy.sb_todo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    @Getter
    @Setter
    private int user_id;

    @Column(name = "user_name")
    @Getter
    @Setter
    private String userName;

    @Column(name = "email", unique = true, nullable = false)
    @Getter
    @Setter
    private String email;

    @Column(name = "password", nullable = false)
    @Getter
    @Setter
    private String password;

    @Column(name = "role")
    @Getter
    @Setter
    private Role role = Role.USER;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Todo> todos = new ArrayList<Todo>();

    public User() {
    }

    public User(int user_id, String userName, String email, String password, Role role) {
        this.user_id = user_id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
