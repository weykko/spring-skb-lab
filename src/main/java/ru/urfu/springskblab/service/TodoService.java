package ru.urfu.springskblab.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.urfu.springskblab.dto.TodoDto;
import ru.urfu.springskblab.entity.EventEntity;
import ru.urfu.springskblab.entity.TodoEntity;
import ru.urfu.springskblab.eventlistener.event.DatabaseChangedEvent;
import ru.urfu.springskblab.eventlistener.event.GetTodoEvent;
import ru.urfu.springskblab.eventlistener.event.MessageSendEvent;
import ru.urfu.springskblab.repository.TodoRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void createTodoList(TodoDto todoDto) {
        TodoEntity todoEntity = new TodoEntity();
        saveTodoEntity(todoDto, todoEntity);

        log.info("Публикация MessageSendEvent");
        applicationEventPublisher.publishEvent(new MessageSendEvent(todoEntity.getName()));

        log.info("Публикация DatabaseChangedEvent");
        applicationEventPublisher.publishEvent(new DatabaseChangedEvent(todoEntity.getId()));
    }

    public void updateTodoList(Long id, TodoDto todoDto) {
        TodoEntity todoEntity = getTodoEntityById(id);
        saveTodoEntity(todoDto, todoEntity);

        log.info("Публикация DatabaseChangedEvent");
        // из-за отсутсвтия анноатации @Transactional событие не прослушается
        applicationEventPublisher.publishEvent(new DatabaseChangedEvent(todoEntity.getId()));
    }

    public TodoDto getTodoList(Long id) {
        TodoEntity todoEntity = getTodoEntityById(id);

        log.info("Публикация GetTodoEvent");
        applicationEventPublisher.publishEvent(new GetTodoEvent(id.toString()));

        return new TodoDto(todoEntity.getName(), todoEntity.getEvents().stream()
                .map(EventEntity::getEvent)
                .collect(Collectors.toList()));
    }

    public List<TodoDto> getAllTodoLists() {
        log.info("Публикация GetTodoEvent");
        applicationEventPublisher.publishEvent(new GetTodoEvent("ALL"));

        return todoRepository.findAll().stream()
                .map(todoList -> new TodoDto(todoList.getName(), todoList.getEvents().stream()
                        .map(EventEntity::getEvent)
                        .collect(Collectors.toList())))
                .toList();
    }

    private TodoEntity getTodoEntityById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TODO лист с id" + id + " не найден"));
    }

    private void saveTodoEntity(TodoDto todoDto, TodoEntity todoEntity) {
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
}
