package com.interview.service;

import com.interview.domain.Command;

public class ActionFactory {
    private static final Action MOVE_FORWARD_ACTION = new MoveForward();
    private static final Action MOVE_BACKWARD_ACTION = new MoveBackward();
    private static final Action LEFT_ROTATION_ACTION = new RotateLeft();
    private static final Action RIGHT_ROTATION_ACTION = new RotateRight();

    public Action getActionByCommand(Command command) {
        switch (command) {
            case MOVE_FORWARD:
                return MOVE_FORWARD_ACTION;
            case MOVE_BACKWARD:
                return MOVE_BACKWARD_ACTION;
            case ROTATE_LEFT:
                return LEFT_ROTATION_ACTION;
            case ROTATE_RIGHT:
                return RIGHT_ROTATION_ACTION;
            default:
                throw new IllegalArgumentException("Command is not supported !" + command);
        }
    }
}
