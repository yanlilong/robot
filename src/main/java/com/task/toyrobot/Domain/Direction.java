package com.task.toyrobot.Domain;

/**
 * Defines the directions EAST, NORTH, SOUTH and WEST that the Robot could face
 */
public enum Direction {
  EAST(0),
  NORTH(1),
  SOUTH(2),
  WEST(3);

  private final int value;

  private Direction(int value) {
    this.value = value;
  }

  /**
   * Get the value of the Direction
   * @return the int value of the Direction
   */
  public int getValue() {
    return value;
  }
}