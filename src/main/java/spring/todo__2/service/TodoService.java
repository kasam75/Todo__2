package spring.todo__2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.todo__2.dto.TodoRequestDto;
import spring.todo__2.dto.TodoResponseDto;
import spring.todo__2.entity.Todo;
import spring.todo__2.entity.User;
import spring.todo__2.repositoy.TodoRepository;
import spring.todo__2.repositoy.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public TodoResponseDto save(TodoRequestDto todoRequestDto) {
        User user = userRepository.findByEmail(todoRequestDto.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("찿을수 없는 이메일입니다."));
        Todo todo = new Todo(
                todoRequestDto.getTitle(),
                todoRequestDto.getDetail(),
                user);
        Todo saveTodo = todoRepository.save(todo);
        return new TodoResponseDto(saveTodo);
    }

    @Transactional(readOnly = true)
    public List<TodoResponseDto> findAll() {
        List<Todo> todos = todoRepository.findAll();
        List<TodoResponseDto> todoResponseDtos = new ArrayList<>();
        for (Todo todo : todos) {
            todoResponseDtos.add(new TodoResponseDto(todo));
        }
        return todoResponseDtos;
    }

    @Transactional(readOnly = true)
    public TodoResponseDto findtodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 할일이 없습니다."));
        return new TodoResponseDto(todo);
    }

    @Transactional
    public TodoResponseDto update(Long todoId, TodoRequestDto todoRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new IllegalArgumentException("원하시는 할일이 없습니다."));
        if (!todo.getUser().getPassword().equals(todoRequestDto.getPassword())) {
            throw new IllegalArgumentException("원하시는 할일이 없습니다.");
        }
        todo.update(
                todoRequestDto.getTitle(),
                todoRequestDto.getDetail());
        return new TodoResponseDto(todo);}

    @Transactional
    public void deleteTodo(Long todoId, String password) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new IllegalArgumentException("원하시는 할일이 없습니다."));
        if (!todo. getUser() .getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        todoRepository.deleteById(todoId);
    }
}