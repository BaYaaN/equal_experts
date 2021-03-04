package com.interview.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.interview.domain.Command.*;
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
                Arguments.arguments(Direction.NORTH, ROTATE_RIGHT, Direction.EAST),
                Arguments.arguments(Direction.EAST, ROTATE_RIGHT, Direction.SOUTH),
                Arguments.arguments(Direction.SOUTH, ROTATE_RIGHT, Direction.WEST),
                Arguments.arguments(Direction.WEST, ROTATE_RIGHT, Direction.NORTH),
                Arguments.arguments(Direction.NORTH, ROTATE_LEFT, Direction.WEST),
                Arguments.arguments(Direction.WEST, ROTATE_LEFT, Direction.SOUTH),
                Arguments.arguments(Direction.SOUTH, ROTATE_LEFT, Direction.EAST),
                Arguments.arguments(Direction.EAST, ROTATE_LEFT, Direction.NORTH),
                Arguments.arguments(Direction.EAST, MOVE_BACKWARD, Direction.EAST),
                Arguments.arguments(Direction.EAST, MOVE_FORWARD, Direction.EAST)
        );
    }
}
