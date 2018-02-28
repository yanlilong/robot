package com.task.toyrobot.service;

import static org.junit.Assert.*;
import org.junit.Test;

import com.task.toyrobot.domain.Direction;
import com.task.toyrobot.domain.RobotPlace;
import com.task.toyrobot.domain.Action;
import com.task.toyrobot.exception.PlaceException;
import com.task.toyrobot.exception.ActionException;

/**
 * Test {@link ParseService}
 */
public class ParseServiceTest {
  @Test
  public void parseActions() throws Exception {
    Action[] actionDirec = {Action.MOVE, Action.RIGHT,Action.REPORT};
    assertArrayEquals(actionDirec, ParseService.parseActions("MOVE,RIGHT,REPORT"));

    Action[] action = {Action.MOVE,Action.REPORT,Action.RIGHT,Action.REPORT};
    assertArrayEquals(action, ParseService.parseActions("MOVE,REPORT,RIGHT,REPORT"));

    Action[] actionLeft = {Action.LEFT,Action.REPORT};
    assertArrayEquals(actionLeft, ParseService.parseActions("LEFT,REPORT"));
  }

  @Test
  public void parseRobotPlace() throws Exception {
    RobotPlace robotPlace = new RobotPlace(0, 1, Direction.NORTH);
    assertEquals(robotPlace, ParseService.parseRobotPlace("0,1,NORTH"));
    robotPlace = new RobotPlace(5, 5, Direction.WEST);
    assertNotEquals(robotPlace, ParseService.parseRobotPlace("5,5,NORTH"));

  }

  @Test(expected = PlaceException.class)
  public void testPlaceException() throws PlaceException {
     ParseService.parseRobotPlace("5,5,TEST");
  }

  @Test(expected = PlaceException.class)
  public void testPlaceInvalidPosition() throws PlaceException {
    ParseService.parseRobotPlace("S,T,TEST");
  }

  @Test(expected = ActionException.class)
  public void testActionException() throws ActionException {
    ParseService.parseActions("MOVE");
  }
}