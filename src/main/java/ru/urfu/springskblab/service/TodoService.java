package ru.urfu.springskblab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.springskblab.dto.TodoDto;
import ru.urfu.springskblab.entity.EventEntity;
import ru.urfu.springskblab.entity.TodoEntity;
import ru.urfu.springskblab.repository.TodoRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void createTodoList(TodoDto todoDto) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setName(todoDto.getName());
        Set<EventEntity> events = todoDto.getEvents().stream()
                .map(eventStr -> {
                    EventEntity todoEvent = new EventEntity();
                    todoEvent.setEvent(eventStr);
                    todoEvent.setTodoList(todoEntity);
                    return todoEvent;
                })
                .collect(Collectors.toSet());

        todoEntity.setEvents(events);

        todoRepository.save(todoEntity);
    }

    public List<TodoDto> getAllTodoLists() {
        return todoRepository.findAll().stream()
                .map(todoList -> {
                    TodoDto todoDto = new TodoDto();
                    todoDto.setName(todoList.getName());
                    todoDto.setEvents(todoList.getEvents().stream()
                            .map(EventEntity::getEvent)
                            .collect(Collectors.toList()));
                    return todoDto;
                })
                .toList();
    }
}
