package ru.urfu.springskblab.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import ru.urfu.springskblab.validation.Password;
import ru.urfu.springskblab.validation.Username;

@Data
public class RegisterRequest {

    @Username
    private String username;

    @Email
    private String email;

    @Password
    private String password;
}
