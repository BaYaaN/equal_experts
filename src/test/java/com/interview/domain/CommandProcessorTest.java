package com.interview.domain;

import com.interview.service.ActionFactory;
import com.interview.service.CommandProcessor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CommandProcessorTest {

    private final CommandProcessor commandProcessor = new CommandProcessor(new ActionFactory());

    @Test
    public void shouldThrownNpeWhenLocationIsNull() {
        //given
        Location startingPoint = null;
        String command = "FLFFFRFLB";

        //then
        assertThatThrownBy(() -> commandProcessor.process(startingPoint, command))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldThrownNpeWhenCommandIsNull() {
        //given
        Location startingPoint = new Location(4, 2, Direction.EAST);
        String command = null;

        //then
        assertThatThrownBy(() -> commandProcessor.process(startingPoint, command))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldEnUpInStartingPositionWhenCommandIsEmpty() {
        //given
        Location startingPoint = new Location(4, 2, Direction.EAST);
        String command = "";

        //when
        Location process = commandProcessor.process(startingPoint, command);

        //then
        assertThat(process.getX()).isEqualTo(4);
        assertThat(process.getY()).isEqualTo(2);
        assertThat(process.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void shouldEnUpInGoodLocation() {
        //given
        Location startingPoint = new Location(4, 2, Direction.EAST);
        String command = "FLFFFRFLB";

        //when
        Location process = commandProcessor.process(startingPoint, command);

        //then
        assertThat(process.getX()).isEqualTo(6);
        assertThat(process.getY()).isEqualTo(4);
        assertThat(process.getDirection()).isEqualTo(Direction.NORTH);
    }
}
