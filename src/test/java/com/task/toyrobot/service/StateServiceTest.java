package com.task.toyrobot.service;

import org.junit.Test;

import com.task.toyrobot.Domain.RobotPlace;

import com.task.toyrobot.Domain.Direction;


public class StateServiceTest {

  @Test
  public void getState() throws Exception {
    RobotPlace expected = new RobotPlace(1, 0, Direction.NORTH);
    //RobotPlace actual = StateService.getRobotPlace(26);
    //assertTrue(expected.equals(actual));
  }

  @Test
  public void getState1() throws Exception {
  }

  @Test
  public void getRobotPlace() throws Exception {
  }

  @Test
  public void buildTransitionTable() throws Exception {
  }

}