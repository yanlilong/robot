package com.task.toyrobot.domain;

/**
 * Defines a custom RobotError Message
 */

public class RobotError {
  private int statusCode;
  private String message;

  /**
   * Default constructor of a RobotError
   *
   * @param statusCode HTTP Ststuscode of error
   * @param message error message
   */
  public RobotError(int statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;

  }

  /**
   * Get HTTP status code
   *
   * @return the int value of status code
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * Get RobotError Message
   *
   * @return the String value of error messsage
   */
  public String getMessage() {
    return message;
  }

}

