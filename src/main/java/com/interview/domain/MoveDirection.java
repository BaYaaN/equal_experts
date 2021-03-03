package com.interview.domain;

import lombok.AllArgsConstructor;

import static java.util.Arrays.stream;

@AllArgsConstructor
public enum MoveDirection {
    MOVE_FORWARD('F'), MOVE_BACKWARD('B');

    private final char symbol;

    public static MoveDirection getBySymbol(char symbol) {
        return stream(MoveDirection.values())
                .filter(value -> value.symbol == symbol)
                .findAny()
                .orElseThrow();
    }
}
