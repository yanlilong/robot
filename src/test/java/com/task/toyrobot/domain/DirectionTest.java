package com.task.toyrobot.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionTest {

  @Test
  public void getValue() throws Exception {
    assertEquals(3, Direction.WEST.getValue());
  }

}