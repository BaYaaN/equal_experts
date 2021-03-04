package com.interview.domain;

import com.interview.service.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ActionFactoryTest {
    private final ActionFactory actionFactory = new ActionFactory();

    @ParameterizedTest
    @MethodSource("parametrized")
    void test(Command command, Class clazz) {
        Action actionByCommand = actionFactory.getActionByCommand(command);

        assertThat(actionByCommand).isInstanceOf(clazz);
    }

    private static Stream<Arguments> parametrized() {
        return Stream.of(
                Arguments.arguments(Command.MOVE_FORWARD, MoveForward.class),
                Arguments.arguments(Command.MOVE_BACKWARD, MoveBackward.class),
                Arguments.arguments(Command.ROTATE_LEFT, RotateLeft.class),
                Arguments.arguments(Command.ROTATE_RIGHT, RotateRight.class)
        );
    }
}
