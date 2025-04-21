package ru.urfu.springskblab.dto;

import lombok.Data;

import java.util.List;

@Data
public class TodoRequest {
    private String name;
    private List<String> events;
}
