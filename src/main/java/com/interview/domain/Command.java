package com.interview.domain;

import lombok.AllArgsConstructor;

import static java.util.Arrays.stream;

@AllArgsConstructor
public enum Command {
    MOVE_FORWARD('F'), MOVE_BACKWARD('B'), ROTATE_LEFT('L'), ROTATE_RIGHT('R');

    private final char symbol;

    public static Command getBySymbol(char symbol) {
        return stream(Command.values())
                .filter(value -> value.symbol == symbol)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Not supported command for symbol: " + symbol));
    }
}
