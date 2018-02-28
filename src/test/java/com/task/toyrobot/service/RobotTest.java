package com.task.toyrobot.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.task.toyrobot.Domain.RobotPlace;
import com.task.toyrobot.Domain.Action;
import com.task.toyrobot.Domain.Direction;

public class RobotTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void run() throws Exception {
    RobotPlace state = new RobotPlace(0, 0, Direction.NORTH);
    state = Robot.run(state, Action.MOVE);
    RobotPlace expected = new RobotPlace(0, 1, Direction.NORTH);
    assertTrue(state.equals(expected));


    state = new RobotPlace(1, 2, Direction.EAST);
    state = Robot.run(state, Action.MOVE, Action.MOVE, Action.LEFT, Action.MOVE);
    expected = new RobotPlace(3, 3, Direction.NORTH);
    assertTrue(state.equals(expected));
  }

}