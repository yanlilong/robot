package com.task.toyrobot.Domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotPlaceTest {

  @Test
  public void isValidPlace() throws Exception {
    //valid
    RobotPlace place=new RobotPlace(0,0,Direction.NORTH);
    assertEquals(place.isValidPlace(),true);

    place=new RobotPlace(2,3,Direction.NORTH);

    //invalid
    assertEquals(place.isValidPlace(),true);

    place=new RobotPlace(5,5,Direction.NORTH);
    assertEquals(place.isValidPlace(),false);

    place=new RobotPlace(0,5,Direction.NORTH);
    assertEquals(place.isValidPlace(),false);

    place=new RobotPlace(5,0,Direction.NORTH);
    assertEquals(place.isValidPlace(),false);

    place=new RobotPlace(0,6,Direction.NORTH);
    assertEquals(place.isValidPlace(),false);

    place=new RobotPlace(-1,0,Direction.NORTH);
    assertEquals(place.isValidPlace(),false);

    place=new RobotPlace(-1,-1,Direction.NORTH);
    assertEquals(place.isValidPlace(),false);

    place=new RobotPlace(-1,-1,Direction.NORTH);
    assertEquals(place.isValidPlace(),false);


    place=new RobotPlace(6,0,Direction.NORTH);
    assertEquals(place.isValidPlace(),false);

    place=new RobotPlace(6,6,Direction.NORTH);
    assertEquals(place.isValidPlace(),false);

    place=new RobotPlace(6,6,Direction.NORTH);
    assertEquals(place.isValidPlace(),false);


  }

}