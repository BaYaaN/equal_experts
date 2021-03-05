package com.interview.service;

import com.interview.domain.Command;
import com.interview.domain.Location;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toUnmodifiableList;

@AllArgsConstructor
public class CommandProcessor {

    private static final Logger LOGGER = Logger.getLogger(CommandProcessor.class.getName());

    private final ActionFactory actionFactory;

    public Location process(@NonNull Location initialLocation, @NonNull String commandAsString) {
        LOGGER.log(Level.INFO, "Start processing command {0}", commandAsString);

        if (commandAsString.length() <= 0) {
            return initialLocation;
        }

        Location currentLocation = initialLocation;

        for (Command command : mapCommandToList(commandAsString)) {
            Action action = actionFactory.getActionByCommand(command);
            currentLocation = action.getNextLocation(currentLocation);
        }

        return currentLocation;
    }

    private Collection<Command> mapCommandToList(String command) {
        return command.toUpperCase()
                .chars()
                .mapToObj(c -> (char) c)
                .map(Command::getBySymbol)
                .collect(toUnmodifiableList());
    }
}
