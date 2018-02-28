package com.task.toyrobot.exception;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test {@link ActionException}
 */
public class ActionExceptionTest {
  ActionException actionException;

  @Before
  public void setUp() throws Exception {
    actionException=new ActionException("invalid Actions");
  }

  @Test
  public void getErrorMessage() throws Exception {
    assertEquals("invalid Actions",actionException.getErrorMessage());
  }

}