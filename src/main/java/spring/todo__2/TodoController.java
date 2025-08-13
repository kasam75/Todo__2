package spring.todo_2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.todo_2.dto.TodoRequestDto;
import spring.todo_2.repositoy.TodoRepository;
import spring.todo_2.service.TodoService;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

//    @PostMapping("/todos")
//    public TodoRequestDto createTodo(@RequestBody TodoRequestDto todoRequestDto) {
//        return todoService.save(todoRequestDto);
    }

