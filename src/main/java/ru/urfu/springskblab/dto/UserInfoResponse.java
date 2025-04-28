package ru.urfu.springskblab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private String username;
    private List<String> roles;
}
