package com.task.toyrobot.service;

import com.task.toyrobot.Domain.Action;
import com.task.toyrobot.Domain.Direction;
import com.task.toyrobot.Domain.RobotPlace;
import com.task.toyrobot.Exception.PlaceException;
import com.task.toyrobot.Exception.ActionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Class that can parse Place String to Place Object and Commands String to array of Action Object.
 */

public class ParseService {

  private static final Logger logger = Logger.getLogger(ParseService.class);

  /**
   * parse actions {@link Action[]} from the given {@link String}.
   *
   * @return Actions[]
   */
  public static Action[] parseActions(String params) throws ActionException {
    String splitAction = params;
    splitAction = StringUtils.upperCase(splitAction);
    if (!StringUtils.contains(splitAction, Action.REPORT.name())) {
      throw new ActionException(
          "Please add REPORT in your Parameter ACTIONS: " + splitAction+ " ,in order to get output");
    }
    String[] actionParts = StringUtils.split(splitAction, ",");

    Action[] actions = new Action[actionParts.length];

    for (int i = 0; i < actionParts.length; i++) {

      if (actionParts[i].equals(Action.MOVE.name()) || actionParts[i].equals(Action.RIGHT.name())
          || actionParts[i]
          .equals(Action.LEFT.name()) || actionParts[i].equals(Action.REPORT.name())) {

        actions[i] = Action.valueOf(actionParts[i]);

      } else {
        throw new ActionException("Invalid parameter ACTIONS:" + actionParts[i]);
      }

    }

    return actions;
  }

  /**
   * parse place {@link RobotPlace} from the given {@link String}.
   *
   * @return RobotPlace
   */

  public static RobotPlace parseRobotPlace(String params) throws PlaceException {
    String splitPlace = params;
    splitPlace = StringUtils.upperCase(splitPlace);
    String[] parts = StringUtils.split(splitPlace, ",");

    if ((parts.length == 3) && (parts[2].equals(Direction.EAST.name()) || parts[2]
        .equals(Direction.NORTH.name()) ||
        parts[2].equals(Direction.SOUTH.name()) || parts[2].equals(Direction.WEST.name()))) {
      final int x = Integer.valueOf(parts[0]);
      final int y = Integer.valueOf(parts[1]);
      final Direction direction = Direction.valueOf(parts[2]);
      return new RobotPlace(x, y, direction);
    } else {
      throw new PlaceException("Invalid Parameter PLACE: " + parts[0] + " " + parts[1] + " " + parts[2]);
    }
  }
}
