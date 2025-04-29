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

    @PutMapping("/{id}")
    public void updateTodoList(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        todoService.updateTodoList(id, todoDto);
    }

    @GetMapping("/{id}")
    public TodoDto getTodoList(@PathVariable Long id) {
        return todoService.getTodoList(id);
    }

    @GetMapping()
    public List<TodoDto> getAllTodoLists() {
        return todoService.getAllTodoLists();
    }
}
