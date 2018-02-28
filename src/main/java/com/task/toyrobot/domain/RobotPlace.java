package com.task.toyrobot.domain;

import com.task.toyrobot.service.StateService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.log4j.Logger;

/**
 * Class that represents Place of a Robot.
 */

public class RobotPlace {
  private int x;
  private int y;
  private Direction direction;

  /**
   * Default constructor of a Robot
   *
   * @param x the position on X axis
   * @param y the position on Y axis
   * @param direction the direction {@link Direction}
   */
  public RobotPlace(int x, int y, Direction direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  /**
   * Get the position of Robot on X axis
   *
   * @return the int value
   */
  public int getX() {
    return this.x;
  }

  /**
   * Get the position of Robot on Y axis
   *
   * @return the int value
   */
  public int getY() {
    return this.y;
  }

  /**
   * Get the direction {@link Direction} of the Robot
   *
   * @return the {@link Direction}
   */
  public Direction getDirection() {
    return this.direction;
  }

  /**
   * Check if this RobotPlace is valid or not
   *
   * @return true if a place of Robot is valid; false otherwise
   */
  @JsonIgnore
  public boolean isValid() {
    if (x >= 0 && x < StateService.X_LENGTH
        && y >= 0 && y < StateService.Y_LEGNTH) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result;
    result = 31 * 31 * x + 31 * y + direction.getValue();
    return result;
  }

  @Override
  public boolean equals(Object object) {
    return this.x == ((RobotPlace) object).getX()
        && this.y == ((RobotPlace) object).getY()
        && this.direction == ((RobotPlace) object).getDirection();
  }
}
