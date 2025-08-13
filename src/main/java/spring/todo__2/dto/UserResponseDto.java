package spring.todo__2.dto;

import lombok.Getter;
import spring.todo__2.entity.User;

@Getter
public class UserResponseDto {
    private final Long id;
    private final String name;
    private final String email;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
