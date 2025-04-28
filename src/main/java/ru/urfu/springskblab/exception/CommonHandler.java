package ru.urfu.springskblab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonHandler {

    @ExceptionHandler(CustomBadGatewayException.class)
    public ResponseEntity<String> handleCustomBadGatewayException(CustomBadGatewayException ex) {
        return new ResponseEntity<>("Custom 502 Bad Gateway: " + ex.getMessage(), HttpStatus.BAD_GATEWAY);
    }
}
