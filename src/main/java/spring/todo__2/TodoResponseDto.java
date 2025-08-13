package spring.todo__2;

import lombok.Getter;

@Getter

public class TodoResponseDto {
    private Long id;
    private final String Name;
    private final String author;
    private final String title;
    private final String detail;
    //내용
    private final String email;

    public TodoResponseDto(Long id,String name, String author, String title, String detail, String email) {
        this.id = id;
        this.Name = name;
        this.author = author;
        this.title = title;
        this.detail = detail;
        this.email = email;

    }
}

