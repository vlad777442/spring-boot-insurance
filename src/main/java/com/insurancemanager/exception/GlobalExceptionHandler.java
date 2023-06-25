package com.insurancemanager.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AgentNotFoundException.class)
    public ModelAndView handleAgentNotFoundException(AgentNotFoundException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("global_error");
        mav.addObject("exceptionType", e);
        mav.addObject("exceptionMessage", "Agent error: " + e.getMessage());
        return mav;
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ModelAndView handleClientNotFoundException(ClientNotFoundException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("global_error");
        mav.addObject("exceptionType", e);
        mav.addObject("exceptionMessage", "Client error: " + e.getMessage());
        return mav;
    }

    @ExceptionHandler(PolicyNotFoundException.class)
    public ModelAndView handlePolicyNotFoundException(PolicyNotFoundException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("global_error");
        mav.addObject("exceptionType", e);
        mav.addObject("exceptionMessage", "Policy error: " + e.getMessage());
        return mav;
    }

    @ExceptionHandler(InsuranceProductNotFoundException.class)
    public ModelAndView handleProductNotFoundException(InsuranceProductNotFoundException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("global_error");
        mav.addObject("exceptionType", e);
        mav.addObject("exceptionMessage", "Insurance Product error: " + e.getMessage());
        return mav;
    }
}
