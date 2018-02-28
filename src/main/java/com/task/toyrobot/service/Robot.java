package com.task.toyrobot.service;

import com.task.toyrobot.Domain.RobotPlace;
import com.task.toyrobot.Domain.Action;
import org.apache.log4j.Logger;

/**
 * Class that represents a robot can move several Actions and report new Place.
 */
public class Robot {

  private static final Logger logger = Logger.getLogger(Robot.class);
  public final static RobotPlace INVALID_STATE = null;

  // transition table in deterministic finite automaton (DFA)
  private final static int[][] transition;

  static {
    transition = StateService.buildTransitionTable();
  }

  /**
   * Asks the robot to do the actions {@link Action} from the given {@link RobotPlace}.
   */
  public static RobotPlace run(RobotPlace robotPlace, Action... actions) {
    // Only accept the
    final int currentState = StateService.getState(robotPlace);
    int newState, lastState;

    newState = currentState;
    lastState = newState;
    for (Action action : actions) {
      if (action == Action.REPORT) {
        // terminate the loop with the FIRST run action
        break;
      }

      if (lastState >= 0 && lastState < transition.length
          && lastState != StateService.INVALID_STATE) {
        // only accept the valid action, the valid action means the
        newState = transition[lastState][action.getValue()];
        lastState = newState;
      }
    }
    if (newState == -1) {
      return INVALID_STATE;
    } else {
      return StateService.getRobotPlace(newState);
    }
  }
}