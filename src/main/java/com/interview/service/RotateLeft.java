package com.interview.service;

import com.interview.domain.Direction;
import com.interview.domain.Location;

import static com.interview.domain.Command.ROTATE_LEFT;

public class RotateLeft implements Action {
    @Override
    public Location moveToNewLocation(Location currentLocation) {
        Direction directionAfterRotation = Direction.rotate(currentLocation.getDirection(), ROTATE_LEFT);
        return new Location(currentLocation.getX(), currentLocation.getY(), directionAfterRotation);
    }
}
