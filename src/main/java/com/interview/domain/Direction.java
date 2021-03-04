package com.interview.domain;

import lombok.NonNull;

import static com.interview.domain.Command.ROTATE_LEFT;
import static com.interview.domain.Command.ROTATE_RIGHT;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    private static final int WEST_ORDINAL_SYNONYM = -1;
    private static final int NORTH_ORDINAL_SYNONYM = 4;

    public static Direction rotate(@NonNull Direction currentDirection, @NonNull Command command) {

        if (command == ROTATE_RIGHT) {
            return getByOrdinal(currentDirection.ordinal() + 1);
        }

        if (command == ROTATE_LEFT) {
            return getByOrdinal(currentDirection.ordinal() - 1);
        }

        return currentDirection;
    }

    private static Direction getByOrdinal(int ordinal) {
        if (ordinal == WEST_ORDINAL_SYNONYM) {
            return WEST;
        }

        if (ordinal == NORTH_ORDINAL_SYNONYM) {
            return NORTH;
        }

        return Direction.values()[ordinal];
    }
}
