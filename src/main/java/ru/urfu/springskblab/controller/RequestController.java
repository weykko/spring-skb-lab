package ru.urfu.springskblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.urfu.springskblab.aspect.RateLimit;
import ru.urfu.springskblab.dto.RequestDto;
import ru.urfu.springskblab.service.RequestService;

@RestController
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @RateLimit
    @GetMapping("/request")
    public RequestDto request() {
        return requestService.request();
    }
}
