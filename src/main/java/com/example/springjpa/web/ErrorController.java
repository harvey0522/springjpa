package com.example.springjpa.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    Logger log= LoggerFactory.getLogger(ErrorController.class);
    @ExceptionHandler
    public String exce(Exception exception){
        log.error(".....---->>>{}",exception.getMessage());
        return "<h1>error</h1>";
    }
}
