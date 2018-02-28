package com.task.toyrobot.exception;

/**
 * custom exception if input parameter ACTIONS is invalid
 */
public class ActionException extends Exception {
  private String errorMessage;

  /**
   * Get error message of the exception
   * @return errorMessage value of the exception
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * Default Constructor
   *
   * @param errorMessage String message
   */
  public ActionException(String errorMessage) {
    super(errorMessage);
    this.errorMessage = errorMessage;
  }
}
