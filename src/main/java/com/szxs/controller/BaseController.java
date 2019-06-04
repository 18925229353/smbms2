package com.szxs.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @ExceptionHandler(value = {RuntimeException.class})
    public String exception(RuntimeException e, HttpServletRequest request){
        request.setAttribute("error",e.getMessage());
        return "login";
    }
}

