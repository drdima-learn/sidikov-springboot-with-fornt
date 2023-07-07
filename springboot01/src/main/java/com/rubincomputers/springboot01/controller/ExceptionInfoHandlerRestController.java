package com.rubincomputers.springboot01.controller;

import com.rubincomputers.springboot01.exception.ErrorInfo;
import com.rubincomputers.springboot01.exception.ErrorType;
import com.rubincomputers.springboot01.util.ValidationUtil;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice(basePackages = "com.rubincomputers.springboot01.controller.rest")
//@Order(Ordered.HIGHEST_PRECEDENCE + 5)
//@Order(Ordered.HIGHEST_PRECEDENCE + 4)
public class ExceptionInfoHandlerRestController {


    //@ResponseStatus(HttpStatus.CONFLICT)  // 409
    //@ExceptionHandler(DataIntegrityViolationException.class)
    public static ErrorInfo conflict(HttpServletRequest req, DataIntegrityViolationException e) {
        System.out.println("exception happened");
        String rootMsg = ValidationUtil.getRootCause(e).getMessage();

        return new ErrorInfo(req.getRequestURL(), ErrorType.DATA_ERROR, rootMsg);
    }


    public static ErrorInfo conflict(String url, DataIntegrityViolationException e) {
        System.out.println("exception happened");
        String rootMsg = ValidationUtil.getRootCause(e).getMessage();

        return new ErrorInfo(url, ErrorType.DATA_ERROR, rootMsg);
    }
}
