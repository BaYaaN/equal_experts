package com.interview.service;

import com.interview.domain.Direction;
import com.interview.domain.Location;

import static com.interview.domain.Command.ROTATE_RIGHT;

public class RotateRight implements Action {
    @Override
    public Location getNextLocation(Location currentLocation) {
        Direction directionAfterRotation = Direction.rotate(currentLocation.getDirection(), ROTATE_RIGHT);
        return new Location(currentLocation.getX(), currentLocation.getY(), directionAfterRotation);
    }
}
