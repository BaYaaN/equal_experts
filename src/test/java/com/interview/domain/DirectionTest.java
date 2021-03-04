package com.interview.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.interview.domain.Command.*;
import static com.interview.domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @ParameterizedTest
    @MethodSource("parametrized")
    void shouldReturnProperDirectionAfterMove(Direction currentDirection, Command command, Direction expected) {
        //when
        Direction result = Direction.rotate(currentDirection, command);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametrized() {
        return Stream.of(
                Arguments.arguments(NORTH, ROTATE_RIGHT, EAST),
                Arguments.arguments(EAST, ROTATE_RIGHT, SOUTH),
                Arguments.arguments(SOUTH, ROTATE_RIGHT, WEST),
                Arguments.arguments(WEST, ROTATE_RIGHT, NORTH),
                Arguments.arguments(NORTH, ROTATE_LEFT, WEST),
                Arguments.arguments(WEST, ROTATE_LEFT, SOUTH),
                Arguments.arguments(SOUTH, ROTATE_LEFT, EAST),
                Arguments.arguments(EAST, ROTATE_LEFT, NORTH),
                Arguments.arguments(EAST, MOVE_BACKWARD, EAST),
                Arguments.arguments(EAST, MOVE_FORWARD, EAST)
        );
    }
}
