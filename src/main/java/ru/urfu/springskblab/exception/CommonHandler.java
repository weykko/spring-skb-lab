package ru.urfu.springskblab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonHandler {

    @ExceptionHandler(CustomBadGatewayException.class)
    public ResponseEntity<String> handleCustomBadGatewayException(CustomBadGatewayException ex) {
        return new ResponseEntity<>("Custom 502 Bad Gateway: " + ex.getMessage(), HttpStatus.BAD_GATEWAY);
    }
}
