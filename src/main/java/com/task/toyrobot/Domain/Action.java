package com.task.toyrobot.Domain;

/**
 * Defines the actions that the Robot could do
 */
public enum Action {
  MOVE(0),
  LEFT(1),
  RIGHT(2),
  REPORT(3);

  private final int value;

  private Action(int value) {
    this.value = value;
  }

  /**
   * Get the value of the Action
   * @return the int value of the Action
   */
  public int getValue() {
    return value;
  }
}