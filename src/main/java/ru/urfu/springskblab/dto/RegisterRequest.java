package ru.urfu.springskblab.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import ru.urfu.springskblab.validation.Password;
import ru.urfu.springskblab.validation.Username;

@Data
public class RegisterRequest {

    @Username
    private String username;

    @NotBlank
    @Email(message = "Почта должна соответствовать формату электронной почты")
    private String email;

    @Password
    private String password;
}
