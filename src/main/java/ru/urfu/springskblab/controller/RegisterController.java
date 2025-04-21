package ru.urfu.springskblab.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.urfu.springskblab.dto.RegisterRequest;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @PostMapping
    public void register(@RequestBody RegisterRequest registerRequest){

    }
}
