package spring.todo__2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private final Long id;

    private final String title;
    private final String detail;
    private final String name;
    private final String email ;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoResponseDto(Long id, String title, String detail, String name,String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}