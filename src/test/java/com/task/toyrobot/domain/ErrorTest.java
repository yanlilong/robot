package com.task.toyrobot.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ErrorTest {


  @Test
  public void getStatusCode() throws Exception {
    Error error=new Error(500,"Interal Server error");
    assertEquals(500,error.getStatusCode());
  }



  @Test
  public void getMessage() throws Exception {

    Error error=new Error(500,"Interal Server error");
    assertEquals("Interal Server error",error.getMessage());
  }


}