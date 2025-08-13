package spring.todo__2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.todo__2.dto.TodoRequestDto;
import spring.todo__2.dto.TodoResponseDto;
import spring.todo__2.service.TodoService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        return todoService.save(todoRequestDto);
    }

    @GetMapping("/todos")
    public List<TodoResponseDto> getTodos() {
        return todoService.findAll();
    }

    @GetMapping("/todos/{todoId}")
    public TodoResponseDto getTodo(@PathVariable Long todoId) {
        return todoService.findtodo(todoId);
    }

    @PutMapping("/todos/{todoId}")
    public TodoResponseDto updateTodo
            (@PathVariable Long todoId,
             @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.update(todoId, todoRequestDto);
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(
            @PathVariable Long todoId,@RequestParam String password) {
        todoService.deleteTodo(todoId,password);
    }
}