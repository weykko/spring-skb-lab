package ru.urfu.springskblab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.urfu.springskblab.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}