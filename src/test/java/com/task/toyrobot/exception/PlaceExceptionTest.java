package com.task.toyrobot.exception;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test {@link PlaceException}
 */
public class PlaceExceptionTest {
  PlaceException placeException;

  @Before
  public void setUp() throws Exception {
    placeException=new PlaceException("invalid place");
  }

  @Test
  public void getErrorMessage() throws Exception {
    assertEquals("invalid place",placeException.getErrorMessage());
  }
}