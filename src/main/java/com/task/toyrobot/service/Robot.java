package com.task.toyrobot.service;

import com.task.toyrobot.domain.RobotPlace;
import com.task.toyrobot.domain.Action;
import org.apache.log4j.Logger;

/**
 * The main entry for Robot Toy to do actions.
 */
public class Robot {

  private static final Logger logger = Logger.getLogger(Robot.class);
  // transition table in deterministic finite automaton (DFA)
  private  final static int[][] transition;
  static {
    transition = StateService.buildTransitionTable();
  }

  /**
   * Asks the robot to do the actions {@link Action} from the given {@link RobotPlace}.
   *
   * @param robotPlace
   * @param actions
   * @return the new {@link RobotPlace}
   */
  public static RobotPlace run(RobotPlace robotPlace, Action ... actions) {
    // Only accept the valid RobotPlace
    final int currentState = StateService.getState(robotPlace);
    int newState, lastState;

    newState = currentState;
    lastState = newState;
    for (Action action : actions) {
      if (action == Action.REPORT) {
        // terminate the loop with the FIRST report and return the lastState
        return StateService.getRobotPlace(lastState);
      }

      // only accept the valid action
      newState = transition[lastState][action.getValue()];
      if (newState != StateService.INVALID_STATE) {
        lastState = newState;
      }
    }
    return StateService.getRobotPlace(lastState);
  }
}