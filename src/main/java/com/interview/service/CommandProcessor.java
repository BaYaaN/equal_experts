package com.interview.service;

import com.interview.domain.Command;
import com.interview.domain.Location;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Collection;

import static java.util.stream.Collectors.toUnmodifiableList;

@AllArgsConstructor
public class CommandProcessor {

    private final ActionFactory actionFactory;

    public Location process(@NonNull Location startingPoint, @NonNull String commandAsString) {
        if (commandAsString.length() <= 0) {
            return startingPoint;
        }

        Location currentLocation = startingPoint;

        for (Command command : mapCommandToList(commandAsString)) {
            Action action = actionFactory.getActionByCommand(command);
            currentLocation = action.moveToNewLocation(currentLocation);
        }

        return currentLocation;
    }

    private Collection<Command> mapCommandToList(String command) {
        return command.toUpperCase()
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> Command.getBySymbol(c))
                .collect(toUnmodifiableList());
    }
}
