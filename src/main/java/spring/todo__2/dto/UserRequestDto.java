package spring.todo__2.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    public  String name;
    private String email;
    private String password;
}
