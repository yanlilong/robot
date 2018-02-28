package com.task.toyrobot.Exception;

/**
 * custom exception if input parameter PLACE is invalid
 */

public class PlaceException extends Exception {

  private String errorMessage;

  /**
   * Get error message of the exception
   *
   * @return errorMessage value of the exception
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  public PlaceException(String errorMessage) {
    super(errorMessage);
    this.errorMessage = errorMessage;
  }

  public PlaceException() {
    super();
  }
}
