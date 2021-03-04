package com.interview.service;

import com.interview.domain.Direction;
import com.interview.domain.Location;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MoveBackwardTest {

    private final Action action = new MoveBackward();

    @ParameterizedTest
    @MethodSource("parametrized")
    void shouldReturnProperLocationAfterMoveBackward(Location currentLocation, Location expected) {
        //when
        Location result = action.moveToNewLocation(currentLocation);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametrized() {
        return Stream.of(
                Arguments.arguments(new Location(5, 10, Direction.NORTH), new Location(5, 9, Direction.NORTH)),
                Arguments.arguments(new Location(5, -10, Direction.NORTH), new Location(5, -11, Direction.NORTH)),
                Arguments.arguments(new Location(0, 0, Direction.NORTH), new Location(0, -1, Direction.NORTH)),
                Arguments.arguments(new Location(5, 10, Direction.SOUTH), new Location(5, 11, Direction.SOUTH)),
                Arguments.arguments(new Location(5, -10, Direction.SOUTH), new Location(5, -9, Direction.SOUTH)),
                Arguments.arguments(new Location(0, 0, Direction.SOUTH), new Location(0, 1, Direction.SOUTH)),
                Arguments.arguments(new Location(5, 10, Direction.WEST), new Location(6, 10, Direction.WEST)),
                Arguments.arguments(new Location(-5, -10, Direction.WEST), new Location(-4, -10, Direction.WEST)),
                Arguments.arguments(new Location(0, 0, Direction.WEST), new Location(1, 0, Direction.WEST)),
                Arguments.arguments(new Location(5, 10, Direction.EAST), new Location(4, 10, Direction.EAST)),
                Arguments.arguments(new Location(-5, -10, Direction.EAST), new Location(-6, -10, Direction.EAST)),
                Arguments.arguments(new Location(0, 0, Direction.EAST), new Location(-1, 0, Direction.EAST))
        );
    }
}
