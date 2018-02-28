package com.task.toyrobot.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test {@link RobotError}
 */
public class RobotErrorTest {
  @Test
  public void getStatusCode() throws Exception {
    RobotError robotError =new RobotError(500,"Internal Server Error");
    assertEquals(500, robotError.getStatusCode());
  }

  @Test
  public void getMessage() throws Exception {
    RobotError robotError =new RobotError(500,"Internal Server Error");
    assertEquals("Internal Server Error", robotError.getMessage());
  }

}