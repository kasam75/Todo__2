package spring.todo__2.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    public  Long name;
    private String email;
    private String password;
}
