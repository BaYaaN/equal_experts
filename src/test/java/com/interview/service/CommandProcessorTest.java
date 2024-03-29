package com.interview.service;

import com.interview.domain.Direction;
import com.interview.domain.Location;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CommandProcessorTest {

    private final CommandProcessor commandProcessor = new CommandProcessor(new ActionFactory());

    @Test
    void shouldThrownNpeWhenLocationIsNull() {
        //given
        Location startingPoint = null;
        String command = "FLFFFRFLB";

        //then
        assertThatThrownBy(() -> commandProcessor.process(startingPoint, command))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void shouldThrownNpeWhenCommandIsNull() {
        //given
        Location startingPoint = new Location(4, 2, Direction.EAST);
        String command = null;

        //then
        assertThatThrownBy(() -> commandProcessor.process(startingPoint, command))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void shouldEnUpInStartingPositionWhenCommandIsEmpty() {
        //given
        Location startingPoint = new Location(4, 2, Direction.EAST);
        String command = "";

        //when
        Location result = commandProcessor.process(startingPoint, command);

        //then
        assertThat(result.getX()).isEqualTo(4);
        assertThat(result.getY()).isEqualTo(2);
        assertThat(result.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void shouldEnUpInGoodLocation() {
        //given
        Location startingPoint = new Location(4, 2, Direction.EAST);
        String command = "FLFFFRFLB";

        //when
        Location result = commandProcessor.process(startingPoint, command);

        //then
        assertThat(result.getX()).isEqualTo(6);
        assertThat(result.getY()).isEqualTo(4);
        assertThat(result.getDirection()).isEqualTo(Direction.NORTH);
    }
}
