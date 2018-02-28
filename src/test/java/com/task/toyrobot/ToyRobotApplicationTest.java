package com.task.toyrobot;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=ToyRobotApplication.class)
public class ToyRobotApplicationTest {

  @Test
  public void applicationContextLoaded() {
  }

  @Test
  public void applicationContextTest() {
    ToyRobotApplication.main(new String[] {});
  }


}