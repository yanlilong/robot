package com.task.toyrobot.web;


import com.task.toyrobot.Exception.ActionException;
import com.task.toyrobot.Exception.PlaceException;
import com.task.toyrobot.service.ParseService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.task.toyrobot.domain.RobotPlace;
import com.task.toyrobot.domain.Action;
import com.task.toyrobot.service.Robot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
public class ToyRobotController {

  private static final Logger logger = Logger.getLogger(ToyRobotController.class);

  @RequestMapping(path = "api/v1/toy-robot")

  @ResponseBody
  public RobotPlace ShowRobotPlace(@RequestParam(required=false, name="PLACE") String place,
      @RequestParam(required=false, name= "ACTIONS", value = "ACTIONS") String commands)
      throws PlaceException, ActionException {

    if (StringUtils.compare(place,"")==0 || StringUtils.compare(place,null)==0) {
      throw new PlaceException("Please give the Robot a Place");
    }

    if (StringUtils.compare(commands,"")==0 || StringUtils.compare(commands,null)==0) {
      throw new ActionException("Please give the Robot ACTIONS");
    }

    RobotPlace robotPlace = ParseService.parseRobotPlace(place);
    if (!robotPlace.isValidPlace()) {
      throw new PlaceException("invalid place: " + place);
    }

    Action[] actions = ParseService.parseActions(commands);
    RobotPlace newState = Robot.run(robotPlace, actions);
    return newState;
  }


  @ExceptionHandler(PlaceException.class)
  public ResponseEntity<String> placeExceptionHandler(Exception ex) {
    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
  }

  @ExceptionHandler(ActionException.class)
  public ResponseEntity<String> actionExceptionHandler(Exception ex) {
    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
  }
}

