package com.idealo.toyrobot.service;

import static org.junit.Assert.*;
import org.junit.Test;

import com.idealo.toyrobot.Domain.Direction;
import com.idealo.toyrobot.Domain.RobotPlace;
import com.idealo.toyrobot.Domain.Action;
import com.idealo.toyrobot.Exception.PlaceException;
import com.idealo.toyrobot.Exception.ActionException;

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

  @Test(expected = ActionException.class)
  public void testActionException() throws ActionException {
    ParseService.parseActions("MOVE");
  }

}