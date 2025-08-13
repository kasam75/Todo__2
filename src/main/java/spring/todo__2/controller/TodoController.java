package spring.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.todo.dto.TodoRequestDto;
import spring.todo.dto.TodoResponseDto;
import spring.todo.service.TodoService;

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
    public TodoResponseDto getTodo(
            @PathVariable Long todoId
    ) {
        return todoService.findTodo(todoId);
    }

    @PutMapping("/todos/{todoId}")
    public TodoResponseDto updateTodo(
            @RequestBody TodoRequestDto todoRequestDto,
            @PathVariable Long todoId
    ) {
        return todoService.update(todoId, todoRequestDto);
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(
            @PathVariable Long todoId,
            @RequestParam String password
    ) {
        todoService.deleteTodo(todoId, password);
    }
}
//삭제 미구현

//리퀘스트바디,페스베리어블,리퀘스트파람(클라이언트에게 데이터를 받는 어노테이션)
//어떤것은 페스워드 필요 어떤것은 패스워드 불필요