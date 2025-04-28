package ru.urfu.springskblab.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Service
public class HeaderService {

    public void getHeaders(Map<String, String> headers, Model model) {
        Map<String, String> headersMap = new HashMap<>();

        for (String key : headers.keySet()) {
            headersMap.put(key, String.join(", ", headers.get(key)));
        }

        model.addAttribute("headers", headersMap);
    }
}
