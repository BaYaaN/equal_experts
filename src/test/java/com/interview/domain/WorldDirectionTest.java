package com.interview.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.interview.domain.Rotation.LEFT;
import static com.interview.domain.Rotation.RIGHT;
import static com.interview.domain.WorldDirection.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WorldDirectionTest {

    @ParameterizedTest
    @MethodSource("parametrized")
    public void shouldReturnProperDirectionAfterRotation(WorldDirection currentDirection, Rotation rotation, WorldDirection expected) {
        //when
        WorldDirection result = WorldDirection.rotate(currentDirection, rotation);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametrized() {
        return Stream.of(
                Arguments.arguments(NORTH, RIGHT, EAST),
                Arguments.arguments(EAST, RIGHT, SOUTH),
                Arguments.arguments(SOUTH, RIGHT, WEST),
                Arguments.arguments(WEST, RIGHT, NORTH),
                Arguments.arguments(NORTH, LEFT, WEST),
                Arguments.arguments(WEST, LEFT, SOUTH),
                Arguments.arguments(SOUTH, LEFT, EAST),
                Arguments.arguments(EAST, LEFT, NORTH)
        );
    }
}
