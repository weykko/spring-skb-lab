package ru.urfu.springskblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.urfu.springskblab.dto.UserInfoResponse;
import ru.urfu.springskblab.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("admin/api")
public class AdminController {

    private final UserService userService;

    @GetMapping
    public UserInfoResponse getUserInfo(@AuthenticationPrincipal UserDetails user) {
        return userService.getUserInfo(user);
    }

}
