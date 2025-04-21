package ru.urfu.springskblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.urfu.springskblab.dto.TodoDto;
import ru.urfu.springskblab.service.TodoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTodoList(@RequestBody TodoDto todoDto) {
        todoService.createTodoList(todoDto);
    }

    @GetMapping()
    public List<TodoDto> getAllTodoLists() {
        return todoService.getAllTodoLists();
    }
}
