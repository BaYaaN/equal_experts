package com.interview.service;

import com.interview.domain.Location;

@FunctionalInterface
public interface Action {
    Location moveToNewLocation(Location currentLocation);
}
