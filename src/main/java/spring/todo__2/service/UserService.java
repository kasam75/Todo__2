package spring.todo__2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import spring.todo__2.dto.UserResponseDto;
import spring.todo__2.dto.UserRequestDto;
import spring.todo__2.entity.User;
import spring.todo__2.repositoy.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;

    @Transactional
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto) {
        User user = new User(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword());
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser);
    }

    @Transactional
    public UserResponseDto updatePassword(Long userId, UserRequestDto requestDto){
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new IllegalArgumentException("찾을수 없는 Id 입니다."));
        user.updatePassword(requestDto.getPassword());
        return new UserResponseDto(user);
    }
    @Transactional
    public UserResponseDto updateEmail(Long userId, UserRequestDto requestDto){
        User user = userRepository.findById(userId).orElseThrow(
                ()->new IllegalArgumentException("찾을수 없는 Id입니다."));
        user.updateEmail(requestDto.getEmail());
        return new UserResponseDto(user);
    }
}
