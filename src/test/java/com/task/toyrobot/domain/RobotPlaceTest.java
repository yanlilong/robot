package com.task.toyrobot.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test {@link RobotPlace}
 */
public class RobotPlaceTest {
  private RobotPlace place;
  @Before
  public void setUp() throws Exception {
    place = new RobotPlace(0, 0, Direction.NORTH);
  }

  @Test
  public void getX() throws Exception {
    assertEquals(0, place.getX());
  }

  @Test
  public void getY() throws Exception {
    assertEquals(0, place.getY());
  }

  @Test
  public void getDirection() throws Exception {
    assertEquals(Direction.NORTH, place.getDirection());
  }

  @Test
  public void testRobotPlaces() throws Exception {
    //valid
    assertTrue(place.isValid());

    place = new RobotPlace(2, 3, Direction.NORTH);

    //valid case
    assertTrue(place.isValid());

    //invalid cases
    place = new RobotPlace(5, 5, Direction.NORTH);
    assertFalse(place.isValid());

    place = new RobotPlace(0, 5, Direction.NORTH);
    assertFalse(place.isValid());

    place = new RobotPlace(5, 0, Direction.NORTH);
    assertFalse(place.isValid());

    place = new RobotPlace(0, 6, Direction.NORTH);
    assertFalse(place.isValid());

    place = new RobotPlace(-1, 0, Direction.NORTH);
    assertFalse(place.isValid());

    place = new RobotPlace(-1, -1, Direction.NORTH);
    assertFalse(place.isValid());

    place = new RobotPlace(-1, -1, Direction.NORTH);
    assertFalse(place.isValid());

    place = new RobotPlace(6, 0, Direction.NORTH);
    assertFalse(place.isValid());

    place = new RobotPlace(6, 6, Direction.NORTH);
    assertFalse(place.isValid());

    place = new RobotPlace(6, 6, Direction.NORTH);
    assertEquals(place.isValid(), false);
  }

}