package spring.todo__2;

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
