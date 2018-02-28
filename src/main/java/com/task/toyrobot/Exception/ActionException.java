package com.task.toyrobot.Exception;

/**
 * @author yanli
 *
 * throw this exception if Action input(Commands) is invalid
 */
public class ActionException extends Exception {

  private String errorMessage;

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
