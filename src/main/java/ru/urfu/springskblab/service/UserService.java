package ru.urfu.springskblab.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.urfu.springskblab.dto.RegisterRequest;

@Service
@Slf4j
public class UserService {

    public void register(RegisterRequest registerRequest) {
        log.info("Регистрация произведена успешно");
    }
}
