package com.task.toyrobot.Exception;

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

  public ActionException(String errorMessage) {
    super(errorMessage);
    this.errorMessage = errorMessage;
  }

  public ActionException() {
    super();
  }

}
