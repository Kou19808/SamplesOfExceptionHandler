package com.example.demo.controller;

import com.example.demo.exception.ControllerException;
import com.example.demo.exception.GlobalException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SimpleController {

    @GetMapping
    public String top() {
        return "top";
    }

    @GetMapping("/cause-controller-exception")
    public String throwControllerException() throws ControllerException {
        throw new ControllerException("From /controller-exception");
    }

    @GetMapping("/cause-global-exception")
    public String throwGlobalException() throws GlobalException {
        throw new GlobalException("From /global-exception");
    }

    @GetMapping("/cause-500")
    public void throwArrayException() {
        throw new ArrayIndexOutOfBoundsException();
    }

    @GetMapping("/cause-null")
    public String throwNullException() {
        throw new NullPointerException();
    }

    @GetMapping("/error/{pageName}")
    public String returnErrorPage(@PathVariable String pageName) {
        return pageName;
    }

    @ExceptionHandler({ControllerException.class})
    public String handleControllerException(ControllerException ce) {
        ce.printStackTrace();
        return "self-error";
    }
}
