package spring.todo__2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.todo__2.dto.TodoRequestDto;
import spring.todo__2.dto.TodoResponseDto;
import spring.todo__2.entity.Todo;
import spring.todo__2.repositoy.TodoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoResponseDto save(TodoRequestDto todoRequestDto) {
        Todo todo = new Todo(
                todoRequestDto.getTitle(),
                todoRequestDto.getDetail(),
                todoRequestDto.getName(),
                todoRequestDto.getEmail(),
                todoRequestDto.getPassword());
        Todo saveTodo = todoRepository.save(todo);
        return new TodoResponseDto(
                saveTodo.getId(),
                saveTodo.getTitle(),
                saveTodo.getDetail(),
                saveTodo.getName(),
                saveTodo.getEmail(),
                saveTodo.getCreatedAt(),
                saveTodo.getModifiedAt()
        );
    }
    @Transactional(readOnly = true)
    public List<TodoResponseDto> findAll() {
        List<Todo> todos = todoRepository.findAll();
        List<TodoResponseDto> todoResponseDtos = new ArrayList<>();
        for(Todo todo : todos){
            TodoResponseDto todoResponseDto = (new TodoResponseDto(
                    todo.getId(),
                    todo.getTitle(),
                    todo.getName(),
                    todo.getDetail(),
                    todo.getEmail(),
                    todo.getCreatedAt(),
                    todo.getModifiedAt()));
            todoResponseDtos.add(todoResponseDto);
        }
        return todoResponseDtos;
    }
@Transactional(readOnly = true)
    public TodoResponseDto findtodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당하는 할일이 없습니다."));
        return new TodoResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDetail(),
                todo.getName(),
                todo.getEmail(),
                todo.getCreatedAt(),
                todo.getModifiedAt());
    }
@Transactional
    public TodoResponseDto update(Long todoid, TodoRequestDto todoRequestDto) {
        Todo todo = todoRepository.findById(todoid).orElseThrow(
                ()->new IllegalArgumentException("원하시는 할일이 없습니다."));
        if(!todo.getPassword().equals(todoRequestDto.getPassword())){
            throw new IllegalArgumentException("원하시는 할일이 없습니다.");
        }
        todo.update(
                todoRequestDto.getTitle(),
                todoRequestDto.getDetail(),
                todoRequestDto.getName(),
                todoRequestDto.getEmail(),
                todoRequestDto.getPassword());
        return new TodoResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDetail(),
                todo.getName(),
                todo.getEmail(),
                todo.getCreatedAt(),
                todo.getModifiedAt());
    }
    @Transactional
    public void deleteTodo(Long todoid,String password) {
        Todo todo = todoRepository.findById(todoid).orElseThrow(
                () -> new IllegalArgumentException("원하시는 할일이 없습니다."));
        if (!todo.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        todoRepository.deleteById(todoid);
    }

}