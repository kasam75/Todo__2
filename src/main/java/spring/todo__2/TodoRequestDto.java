package spring.todo_2.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {
    private String Name;
    private String author;
    private String title;
    private String detail;
    //내용
    private String email;
    private String password;
}
