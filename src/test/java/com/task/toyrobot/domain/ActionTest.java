package com.task.toyrobot.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test {@link Action}
 */
public class ActionTest {

  @Test
  public void getValue() throws Exception {

    assertEquals(0, Action.MOVE.getValue());
    assertEquals(3, Action.REPORT.getValue());
    assertEquals(1, Action.LEFT.getValue());
    assertEquals(2, Action.RIGHT.getValue());
  }

}