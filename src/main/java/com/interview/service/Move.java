package com.interview.service;

import com.interview.domain.Location;
import com.interview.domain.WorldDirection;

public interface Move {
    public Location move (Location cuLocation, WorldDirection worldDirection);
}
