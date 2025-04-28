package ru.urfu.springskblab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TodoDto {
    private String name;
    private List<String> events;
}
