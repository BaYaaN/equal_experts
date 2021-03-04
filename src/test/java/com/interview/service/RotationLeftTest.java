package com.interview.service;

import com.interview.domain.Direction;
import com.interview.domain.Location;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RotationLeftTest {

    private final Action action = new RotateLeft();

    @ParameterizedTest
    @MethodSource("parametrized")
    void shouldReturnProperLocationAfterLeftRotation(Location currentLocation, Location expected) {
        //when
        Location result = action.moveToNewLocation(currentLocation);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametrized() {
        return Stream.of(
                Arguments.arguments(new Location(5, 10, Direction.NORTH), new Location(5, 10, Direction.WEST)),
                Arguments.arguments(new Location(5, -10, Direction.EAST), new Location(5, -10, Direction.NORTH)),
                Arguments.arguments(new Location(0, 0, Direction.SOUTH), new Location(0, 0, Direction.EAST)),
                Arguments.arguments(new Location(0, 0, Direction.WEST), new Location(0, 0, Direction.SOUTH))

        );
    }
}
