package ru.urfu.springskblab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RequestDto {
    private Long requestCount;
    private LocalDateTime lastRequestTime;
}
