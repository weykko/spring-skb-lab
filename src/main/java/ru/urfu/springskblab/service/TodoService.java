package ru.urfu.springskblab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.springskblab.dto.TodoRequest;
import ru.urfu.springskblab.repository.TodoRepository;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void createTodoList(TodoRequest todoRequest) {

        todoRepository.save()
    }
}
