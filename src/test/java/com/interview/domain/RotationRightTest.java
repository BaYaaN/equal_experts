package com.interview.domain;

import com.interview.service.Action;
import com.interview.service.RotateRight;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.interview.domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RotationRightTest {

    private final Action action = new RotateRight();

    @ParameterizedTest
    @MethodSource("parametrized")
    public void shouldReturnProperLocationAfterRightRotation(Location currentLocation, Location expected) {
        //when
        Location result = action.moveToNewLocation(currentLocation);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametrized() {
        return Stream.of(
                Arguments.arguments(new Location(5, 10, NORTH), new Location(5, 10, EAST)),
                Arguments.arguments(new Location(5, -10, EAST), new Location(5, -10, SOUTH)),
                Arguments.arguments(new Location(0, 0, SOUTH), new Location(0, 0, WEST)),
                Arguments.arguments(new Location(0, 0, WEST), new Location(0, 0, NORTH))

        );
    }
}
