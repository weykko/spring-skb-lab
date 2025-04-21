package ru.urfu.springskblab.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "todo_lists")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "todo_lists", cascade = CascadeType.ALL)
    private List<EventEntity> events;
}
