package com.interview.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTest {

    @ParameterizedTest
    @MethodSource("parametrized")
    void shouldReturnProperCommandForGivenSymbol(char symbol, Command expected) {
        //when
        Command result = Command.getBySymbol(symbol);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldThrowExceptionWhenCommandIsNotSupporte() {
        //given
        char symbol = 'X';

        //when
        assertThatThrownBy(() -> Command.getBySymbol(symbol))
                .isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("Not supported command for symbol: " + symbol);
    }

    private static Stream<Arguments> parametrized() {
        return Stream.of(
                Arguments.arguments('F', Command.MOVE_FORWARD),
                Arguments.arguments('B', Command.MOVE_BACKWARD),
                Arguments.arguments('L', Command.ROTATE_LEFT),
                Arguments.arguments('R', Command.ROTATE_RIGHT)
        );
    }
}
