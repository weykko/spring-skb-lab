package ru.urfu.springskblab.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.urfu.springskblab.dto.RegisterRequest;
import ru.urfu.springskblab.service.UserService;

@Slf4j
@RestController
@RequestMapping("/register")
@Validated
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterRequest registerRequest){
        userService.register(registerRequest);
    }
}
