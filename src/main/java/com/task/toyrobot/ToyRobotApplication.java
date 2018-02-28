package com.task.toyrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
//@SpringBootApplication  is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan
public class ToyRobotApplication {
  public static void main(String[] args){
    ApplicationContext ctx=SpringApplication.run(ToyRobotApplication.class,args);
    }

 }
