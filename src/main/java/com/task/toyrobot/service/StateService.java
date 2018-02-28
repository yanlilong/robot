package com.task.toyrobot.service;

import com.task.toyrobot.Domain.Action;
import com.task.toyrobot.Domain.Direction;
import com.task.toyrobot.Domain.RobotPlace;
import org.apache.log4j.Logger;

/**
 * The utility class that includes the calculation on the deterministic finite automaton.
 *
 * <p> Every {@link RobotPlace} having the valid pisition on X axis and Y axis with the direction
 * can be treated as a defined state in DFA. So the actions that the Robot receives can be treated
 * as the transition conditions among the states. The transition table is a two-dimension array. The
 * row represents all the possible RobotPlace, which is the int value calculated by it position on
 * X, Y axis and the direction. The column are he transition conditions, and are the actions in this
 * case.
 *
 * For example, the value of transition[0][1] is 36. It means that for the RobotPlace(0, 0, EAST),
 * with action "LEFT", its new state is 36, which represents the (0, 0, NORTH).
 *
 * Through the DFA, the lookup and determination for chain of actions is very fast. </p>
 */
public class StateService {

  private static final Logger logger = Logger.getLogger(StateService.class);

  //ToDo: make these two variable
  public static final int X_LENGTH = 4;
  public static final int Y_LEGNTH = 4;

  public static final int INVALID_STATE = -1;

  // The change table on X axis based on the action. The row is the direction, and the column is the action
  private static final int[][] X_MOVE_CHANGE = new int[Direction.values().length][Action
      .values().length];

  static {
    // move on x axis, only east & west
    X_MOVE_CHANGE[Direction.EAST.getValue()][Action.MOVE.getValue()] = 1;
    X_MOVE_CHANGE[Direction.WEST.getValue()][Action.MOVE.getValue()] = -1;
  }

  // The change table on Y axis based on the action. The row is the direction, and the column is the action
  private static final int[][] Y_MOVE_CHANGE = new int[Direction.values().length][Action
      .values().length];

  static {
    // move on y axis, only north & south
    Y_MOVE_CHANGE[Direction.NORTH.getValue()][Action.MOVE.getValue()] = 1;
    Y_MOVE_CHANGE[Direction.SOUTH.getValue()][Action.MOVE.getValue()] = -1;
  }

  // The direction change table based on the action. The row is the direction, and the column is the action
  private static final int[][] DIRECTION_CHANGE = new int[Direction.values().length][Action
      .values().length];

  static {
    DIRECTION_CHANGE[Direction.EAST.getValue()][Action.LEFT.getValue()] = Direction.NORTH
        .getValue();
    DIRECTION_CHANGE[Direction.NORTH.getValue()][Action.LEFT.getValue()] = Direction.WEST
        .getValue();
    DIRECTION_CHANGE[Direction.SOUTH.getValue()][Action.LEFT.getValue()] = Direction.EAST
        .getValue();
    DIRECTION_CHANGE[Direction.WEST.getValue()][Action.LEFT.getValue()] = Direction.SOUTH
        .getValue();

    DIRECTION_CHANGE[Direction.EAST.getValue()][Action.RIGHT.getValue()] = Direction.SOUTH
        .getValue();
    DIRECTION_CHANGE[Direction.NORTH.getValue()][Action.RIGHT.getValue()] = Direction.EAST
        .getValue();
    DIRECTION_CHANGE[Direction.SOUTH.getValue()][Action.RIGHT.getValue()] = Direction.WEST
        .getValue();
    DIRECTION_CHANGE[Direction.WEST.getValue()][Action.RIGHT.getValue()] = Direction.NORTH
        .getValue();

    // For move action, the direction should not be changed
    DIRECTION_CHANGE[Direction.EAST.getValue()][Action.MOVE.getValue()] = Direction.EAST.getValue();
    DIRECTION_CHANGE[Direction.NORTH.getValue()][Action.MOVE.getValue()] = Direction.NORTH
        .getValue();
    DIRECTION_CHANGE[Direction.SOUTH.getValue()][Action.MOVE.getValue()] = Direction.SOUTH
        .getValue();
    DIRECTION_CHANGE[Direction.WEST.getValue()][Action.MOVE.getValue()] = Direction.WEST.getValue();

    // For run action, direction should not be changed
    DIRECTION_CHANGE[Direction.EAST.getValue()][Action.REPORT.getValue()] = Direction.EAST
        .getValue();
    DIRECTION_CHANGE[Direction.NORTH.getValue()][Action.REPORT.getValue()] = Direction.NORTH
        .getValue();
    DIRECTION_CHANGE[Direction.SOUTH.getValue()][Action.REPORT.getValue()] = Direction.SOUTH
        .getValue();
    DIRECTION_CHANGE[Direction.WEST.getValue()][Action.REPORT.getValue()] = Direction.WEST
        .getValue();
  }

  /**
   * Get the state in DFA based on the given {@param x}, {@param y} and {@param direction}.
   *
   * @param x the int position on X axis
   * @param y the int position on Y axis
   * @param direction the direction {@link Direction}
   * @return the int state value
   */
  public static int getState(int x, int y, Direction direction) {
    if (x < 0 || x >= X_LENGTH || y < 0 || y >= Y_LEGNTH) {
      return INVALID_STATE;
    }
    int value = direction.getValue();

    return X_LENGTH * Y_LEGNTH * value + Y_LEGNTH * y + x;
  }

  /**
   * Get the state in DFA on the given {@param robotPlace}
   *
   * @param robotPlace the {@link RobotPlace}
   * @return the int state value
   */
  public static int getState(RobotPlace robotPlace) {
    return getState(robotPlace.getX(), robotPlace.getY(), robotPlace.getDirection());
  }

  /**
   * Get the RobotPlace based on the given state
   *
   * @param state the int value
   * @return the {@link RobotPlace} if the state is valid
   */
  public static RobotPlace getRobotPlace(int state) {
    if (state >= X_LENGTH * Y_LEGNTH * Direction.values().length || state < 0) {
      // Invalide state value
      return null;
    }
    int direction = state / (X_LENGTH * Y_LEGNTH);

    int tail = state - X_LENGTH * Y_LEGNTH * direction;
    int y = tail / Y_LEGNTH;

    int x = tail - Y_LEGNTH * y;
    return new RobotPlace(x, y, Direction.values()[direction]);
  }

  /**
   * Builds the transition table of deterministic finite automaton (DFA) used in the Robot playing.
   *
   * <p> The row is the state calculated for very possible {@link RobotPlace}, and the column are
   * the actions. </p>
   *
   * @return the two-dimension array
   */
  public static int[][] buildTransitionTable() {
    int[][] transition = new int[X_LENGTH * Y_LEGNTH * Direction.values().length][Action
        .values().length];

    int newState;
    int x, y, direction;
    int xbase, ybase;
    RobotPlace robotPlace;
    for (int state = 0; state < X_LENGTH * Y_LEGNTH * Direction.values().length; state++) {
      robotPlace = getRobotPlace(state);
      xbase = robotPlace.getX();
      ybase = robotPlace.getY();
      direction = robotPlace.getDirection().getValue();
      if (xbase == 0 && ybase == 0 && robotPlace.getDirection() == Direction.SOUTH) {
        logger.info("stop here");
      }
      for (int action = 0; action < Action.values().length; action++) {
        x = xbase + X_MOVE_CHANGE[direction][action];
        y = ybase + Y_MOVE_CHANGE[direction][action];
        direction = DIRECTION_CHANGE[direction][action];
        newState = getState(x, y, Direction.values()[direction]);
        transition[state][action] = newState;
      }
    }

    return transition;
  }
}