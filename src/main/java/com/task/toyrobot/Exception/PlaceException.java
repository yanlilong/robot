package com.task.toyrobot.Exception;

/**
 * @author yanli
 *
 * throw this exception if input place is invalid
 */

public class PlaceException extends Exception{
  private String errorMessage;

  public String getErrorMessage() {
    return errorMessage;
  }
  public PlaceException(String errorMessage){
    super(errorMessage);
    this.errorMessage=errorMessage;
  }
  public PlaceException(){
    super();
  }
}
