package ru.urfu.springskblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.urfu.springskblab.service.HeaderService;

import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/headers")
public class HeadersController {

    private final HeaderService headerService;

    @GetMapping
    public String getHeaders(@RequestHeader Map<String, String> headers, Model model) {
        headerService.getHeaders(headers, model);
        return "headers";
    }

}
