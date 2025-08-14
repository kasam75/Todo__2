package spring.todo__2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.todo__2.dto.UserResponseDto;
import spring.todo__2.dto.UserRequestDto;
import spring.todo__2.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @PostMapping("/signup")
    public UserResponseDto signup(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @PutMapping("/users/{userId}/password")
    public UserResponseDto updatePassword(
            @PathVariable Long userId,
            @RequestBody UserRequestDto requestDto) {
        return userService.updatePassword(userId, requestDto);
    }

    @PutMapping("/users/{userId}/email")
    public UserResponseDto updateEmail(
            @PathVariable Long userId,
            @RequestBody UserRequestDto requestDto) {
        return userService.updateEmail(userId,requestDto);
    }
}
