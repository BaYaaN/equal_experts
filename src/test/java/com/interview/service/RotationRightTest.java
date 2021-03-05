package com.interview.service;

import com.interview.domain.Direction;
import com.interview.domain.Location;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RotationRightTest {

    private final Action action = new RotateRight();

    @ParameterizedTest
    @MethodSource("parametrized")
    void shouldReturnProperLocationAfterRightRotation(Location currentLocation, Location expected) {
        //when
        Location result = action.getNextLocation(currentLocation);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametrized() {
        return Stream.of(
                Arguments.arguments(new Location(5, 10, Direction.NORTH), new Location(5, 10, Direction.EAST)),
                Arguments.arguments(new Location(5, -10, Direction.EAST), new Location(5, -10, Direction.SOUTH)),
                Arguments.arguments(new Location(0, 0, Direction.SOUTH), new Location(0, 0, Direction.WEST)),
                Arguments.arguments(new Location(0, 0, Direction.WEST), new Location(0, 0, Direction.NORTH))

        );
    }
}
