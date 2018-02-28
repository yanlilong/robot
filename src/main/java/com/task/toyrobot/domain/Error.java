package com.task.toyrobot.domain;

/**
 * Defines a custom Error Message
 */

public class Error {

  private int statusCode;
  private String message;
  /**
   * Default constructor of a Error
   *
   * @param statusCode HTTP Ststuscode of error
   * @param message error message
   */
  public Error(int statusCode, String message) {
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
   * Get Error Message
   *
   * @return the String value of error messsage
   */
  public String getMessage() {
    return message;
  }

}

