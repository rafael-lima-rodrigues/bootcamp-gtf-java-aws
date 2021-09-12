package com.globallabs.springwebmvc.rest;

import com.globallabs.springwebmvc.exception.JediNotFoundExeception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(JediNotFoundExeception.class)
    public void notFound(){}

}
