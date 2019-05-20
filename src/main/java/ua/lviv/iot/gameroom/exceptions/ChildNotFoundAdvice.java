package ua.lviv.iot.gameroom.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ChildNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ChildNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String childNotFoundHandler(ChildNotFoundException e) {
        return e.getMessage();
    }

}
