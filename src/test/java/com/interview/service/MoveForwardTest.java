package com.interview.service;

import com.interview.domain.Location;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.interview.domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class MoveForwardTest {

    private final Action action = new MoveForward();

    @ParameterizedTest
    @MethodSource("parametrized")
    void shouldReturnProperLocationAfterMoveForward(Location currentLocation, Location expected) {
        //when
        Location result = action.getNextLocation(currentLocation);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametrized() {
        return Stream.of(
                Arguments.arguments(new Location(5, 10, NORTH), new Location(5, 11, NORTH)),
                Arguments.arguments(new Location(5, -10, NORTH), new Location(5, -9, NORTH)),
                Arguments.arguments(new Location(0, 0, NORTH), new Location(0, 1, NORTH)),
                Arguments.arguments(new Location(5, 10, SOUTH), new Location(5, 9, SOUTH)),
                Arguments.arguments(new Location(5, -10, SOUTH), new Location(5, -11, SOUTH)),
                Arguments.arguments(new Location(0, 0, SOUTH), new Location(0, -1, SOUTH)),
                Arguments.arguments(new Location(5, 10, WEST), new Location(4, 10, WEST)),
                Arguments.arguments(new Location(-5, -10, WEST), new Location(-6, -10, WEST)),
                Arguments.arguments(new Location(0, 0, WEST), new Location(-1, 0, WEST)),
                Arguments.arguments(new Location(5, 10, EAST), new Location(6, 10, EAST)),
                Arguments.arguments(new Location(-5, -10, EAST), new Location(-4, -10, EAST)),
                Arguments.arguments(new Location(0, 0, EAST), new Location(1, 0, EAST))
        );
    }
}
