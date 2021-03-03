package com.interview.service;

import com.interview.domain.Direction;
import com.interview.domain.Location;

public class MoveBackward implements Action {

    @Override
    public Location moveToNewLocation(Location currentLocation) {
        int currentX = currentLocation.getX();
        int currentY = currentLocation.getY();
        Direction currentDirection = currentLocation.getDirection();

        switch (currentDirection) {
            case NORTH:
                --currentY;
                break;
            case SOUTH:
                ++currentY;
                break;
            case EAST:
                --currentX;
                break;
            case WEST:
                ++currentX;
                break;
        }

        return new Location(currentX, currentY, currentDirection);
    }
}
