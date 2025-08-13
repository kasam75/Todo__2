package spring.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String detail;
    private String name;
    private String password;

    public Todo(String title, String detail, String name, String password) {
        this.title = title;
        this.detail = detail;
        this.name = name;
        this.password = password;
    }

    public void update(String title, String detail, String name, String password) {
        this.title = title;
        this.detail = detail;
        this.name = name;
        this.password = password;
    }
}
