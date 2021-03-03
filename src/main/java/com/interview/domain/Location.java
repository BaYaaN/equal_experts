package com.interview.domain;

import lombok.Value;

@Value
public class Location {
    int x;
    int y;
    WorldDirection worldDirection;
}
