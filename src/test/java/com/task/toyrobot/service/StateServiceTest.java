package com.task.toyrobot.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.task.toyrobot.domain.RobotPlace;

import com.task.toyrobot.domain.Direction;


public class StateServiceTest {

  @Test
  public void testGetNumericState() {
    int expected = 0;
    int actual = StateService.getState(0, 0, Direction.EAST);
    assertTrue("Actural state is not correct", expected == actual);

    expected = 25;
    actual = StateService.getState(0, 0, Direction.NORTH);
    assertTrue( "Actural state is not correct", expected == actual);
  }

  @Test
  public void getRobotState() {
    RobotPlace expected = new RobotPlace(1, 0, Direction.NORTH);
    RobotPlace actual = StateService.getRobotPlace(26);

    assertTrue("Actual state is not correct", expected.equals(actual));
  }

  @Test
  public void testCreateTransitionTable() {
    int[][] transition = StateService.buildTransitionTable();
    assertTrue("Number of state is wrong", transition.length == 100);
  }
}