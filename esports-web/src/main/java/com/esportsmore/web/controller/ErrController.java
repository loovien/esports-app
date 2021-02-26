package com.esportsmore.web.controller;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @ControllerAdvice
@Component
public class ErrController extends ExceptionHandlerExceptionResolver {

    /* @ExceptionHandler(value = Exception.class)
    public ModelAndView e404() {
        ModelAndView e404 = new ModelAndView("e404");
        e404.addObject("message", "404 Not Found");
        return e404;
    }*/

    @Override
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception exception) {
        ModelAndView modelAndView = super.doResolveHandlerMethodException(request, response, handlerMethod, exception);
        modelAndView.setViewName("e404");
        return modelAndView;
    }
}
