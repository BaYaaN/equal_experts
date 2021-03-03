package com.interview.domain;

import lombok.NonNull;

import static com.interview.domain.Rotation.RIGHT;

public enum WorldDirection {
    NORTH, EAST, SOUTH, WEST;

    private static final int WEST_ORDINAL_SYNONYM = -1;
    private static final int NORTH_ORDINAL_SYNONYM = 4;

    public static WorldDirection rotate(@NonNull WorldDirection currentWorldDirection, @NonNull Rotation rotation) {
        if (rotation == RIGHT) {
            return getByOrdinal(currentWorldDirection.ordinal() + 1);
        }

        return getByOrdinal(currentWorldDirection.ordinal() - 1);
    }

    private static WorldDirection getByOrdinal(int ordinal) {
        if (ordinal == WEST_ORDINAL_SYNONYM) {
            return WEST;
        }

        if (ordinal == NORTH_ORDINAL_SYNONYM) {
            return NORTH;
        }

        return WorldDirection.values()[ordinal];
    }
}
