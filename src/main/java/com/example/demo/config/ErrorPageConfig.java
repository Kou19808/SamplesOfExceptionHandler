package com.example.demo.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        var error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/self-500");
        var error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/self-404");
        var errorNull = new ErrorPage(NullPointerException.class, "/error/self-null");

        registry.addErrorPages(error500, error404, errorNull);
    }
}
