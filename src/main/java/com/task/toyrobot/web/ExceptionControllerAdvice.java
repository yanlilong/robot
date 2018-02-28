package com.task.toyrobot.web;

import com.task.toyrobot.domain.RobotError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice(annotations = Controller.class)
@EnableWebMvc
public class ExceptionControllerAdvice {
  @ExceptionHandler(Exception.class)
  public ResponseEntity<RobotError> exceptionHandler(Exception ex) {
    RobotError robotError = new RobotError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"ToyRobot-API System robotError");
    return new ResponseEntity<RobotError>(robotError, HttpStatus.OK);
  }
}

