package ru.urfu.springskblab.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.urfu.springskblab.dto.RequestDto;

import java.time.LocalDateTime;

@Getter
@Service
public class RequestService {

    private Long requestCount;
    private LocalDateTime lastRequestTime;

    private RequestService() {
        requestCount = 0L;
        lastRequestTime = null;
    }

    public RequestDto request() {
        RequestDto requestDto = new RequestDto(++requestCount, lastRequestTime);
        lastRequestTime = LocalDateTime.now();

        return requestDto;
    }
}
