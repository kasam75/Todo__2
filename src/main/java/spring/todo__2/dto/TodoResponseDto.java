package spring.todo__2.dto;

import lombok.Getter;
import spring.todo__2.entity.Todo;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private final Long id;

    private final String title;
    private final String detail;
    private final String username;
    private final String email ;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.detail = todo.getDetail();
        this.username = todo.getUser().getName();
        this.email = todo.getUser().getEmail();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}