package com.task.toyrobot.service;

import com.task.toyrobot.domain.Action;
import com.task.toyrobot.domain.Direction;
import com.task.toyrobot.domain.RobotPlace;
import com.task.toyrobot.exception.PlaceException;
import com.task.toyrobot.exception.ActionException;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Class that can parse Place String to Place Object and Commands String to array of Action Object.
 */

public class ParseService {
  private final static String COMMA = ",";

  /**
   * parse actions {@link Action[]} from the given {@link String}.
   *
   * @return Actions[]
   */
  public static Action[] parseActions(final String params) throws ActionException {
    final String[] parts = StringUtils.split(params, COMMA);
    final String[] actionParts = Arrays.stream(parts).map(String::trim).toArray(String[]::new);

    final Action[] actions = new Action[actionParts.length];

    for (int i = 0; i < actionParts.length; i++) {
      if (validAction(actionParts[i])) {
        actions[i] = Action.valueOf(actionParts[i]);
      } else {
        throw new ActionException("Invalid parameter ACTIONS:" + parts[i]);
      }
    }

    if (!Arrays.asList(actions).contains(Action.REPORT)) {
      throw new ActionException(
          "Please add REPORT in your Parameter ACTIONS: " + params + " ,in order to get output");
    }

    return actions;
  }

  private static boolean validAction(final String param) {
    for (Action action : Action.values()) {
      if (action.name().equals(param.toUpperCase())) {
        return true;
      }
    }
    return false;
  }

  /**
   * parse place {@link RobotPlace} from the given {@link String}.
   *
   * @return RobotPlace
   */

  public static RobotPlace parseRobotPlace(final String params) throws PlaceException {
    final String[] parts = StringUtils.split(params, COMMA);
    final String[] placeParts = Arrays.stream(parts).map(String::trim).toArray(String[]::new);

    if (placeParts.length == 3 && validDirection(placeParts[2])) {
      try {
        int x = Integer.valueOf(placeParts[0]);
        int y = Integer.valueOf(placeParts[1]);
        Direction direction = Direction.valueOf(placeParts[2]);
        return new RobotPlace(x, y, direction);
      } catch (NumberFormatException e){
        throw new PlaceException("Invalid Position for RobotPlace: " + parts[0] + " " + parts[1]);
      }
    } else {
      throw new PlaceException("Invalid Parameter for a RobotPlace: " + parts[0] + " " + parts[1] + " " + parts[2]);
    }
  }

  private static boolean validDirection(final String param) {
    for (Direction direction : Direction.values()) {
      if (direction.name().equals(param.toUpperCase())) {
        return true;
      }
    }
    return false;
  }
}
