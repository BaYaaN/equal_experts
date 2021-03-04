package com.interview;


import com.interview.domain.Direction;
import com.interview.domain.Location;
import com.interview.service.ActionFactory;
import com.interview.service.CommandProcessor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());
    private static final CommandProcessor COMMAND_PROCESSOR = new CommandProcessor(new ActionFactory());

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Missing input parameters. Can not properly process command");
        }

        Location initialLocation = getInitialLocation(args);
        final String command = args[3];

        LOGGER.log(Level.INFO, "Mars Rover landed at Location ({0},{1},{2})",
                new Object[]{initialLocation.getX(), initialLocation.getY(), initialLocation.getDirection()});

        Location finalLocation = COMMAND_PROCESSOR.process(initialLocation, command);

        LOGGER.log(Level.INFO, "Mars Rover final location is ({0},{1},{2})",
                new Object[]{finalLocation.getX(), finalLocation.getY(), finalLocation.getDirection()});

    }

    private static final Location getInitialLocation(String[] args) {
        return new Location(Integer.valueOf(args[0]), Integer.valueOf(args[1]), Direction.valueOf(args[2]));
    }
}
