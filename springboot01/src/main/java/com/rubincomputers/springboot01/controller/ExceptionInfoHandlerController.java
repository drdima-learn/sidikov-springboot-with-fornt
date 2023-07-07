package com.rubincomputers.springboot01.controller;

import com.rubincomputers.springboot01.util.ValidationUtil;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

//@ControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE + 4)
//@Order(Ordered.HIGHEST_PRECEDENCE + 5)
public class ExceptionInfoHandlerController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView conflict(DataIntegrityViolationException e) {
        System.out.println("exception happened");

        HttpStatus httpStatus = HttpStatus.CONFLICT;
        Throwable rootCause = ValidationUtil.getRootCause(e);
        ModelAndView mav = new ModelAndView("exception",
                Map.of("exception", rootCause,
                        "message", rootCause.toString(),
                        "status", httpStatus));
        mav.setStatus(httpStatus);
        return mav;
    }
}
