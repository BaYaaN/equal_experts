package com.interview.domain;

import lombok.AllArgsConstructor;

import static java.util.Arrays.stream;

@AllArgsConstructor
public enum Rotation {
    LEFT('L'), RIGHT('R');

    private final char symbol;

    public static Rotation getBySymbol(char symbol) {
        return stream(Rotation.values())
                .filter(value -> value.symbol == symbol)
                .findAny()
                .orElseThrow();
    }
}
