package spring.todo__2.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "userId",nullable =false)
    private User user;


    public Todo(String title, String detail, User user) {
        this.title = title;
        this.detail = detail;
        this.user = user;
    }

    public void update(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }
}
