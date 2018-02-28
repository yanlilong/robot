package com.task.toyrobot.web;

import com.task.toyrobot.Domain.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = Controller.class)
@EnableWebMvc
public class ExceptionControllerAdvice {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Error> exceptionHandler(Exception ex) {
    Error error = new Error();
    error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    error.setMessage("ToyRobot-API Systemerror");
    return new ResponseEntity<Error>(error, HttpStatus.OK);

  }

  @ExceptionHandler({NoHandlerFoundException.class})
  protected ResponseEntity<Error> handleNotFoundRequest(Exception e, HttpServletRequest request) {
    Error error = new Error();
    error.setStatusCode(HttpStatus.NOT_FOUND.value());
    error.setMessage("Request resource not Found");
    return new ResponseEntity<Error>(error, HttpStatus.OK);
  }


}

