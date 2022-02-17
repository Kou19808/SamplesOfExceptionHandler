package com.example.demo.controller.advice;

import com.example.demo.exception.GlobalException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvise {

    @ExceptionHandler({GlobalException.class})
    public String handleGlobalException(GlobalException ge) {
        ge.printStackTrace();
        return "self-error";
    }
}
