package grupp0.arena.base.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.model.UserType;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a command.
 *
 * @author Philip Arvidsson (S133686)
 */
public abstract class Command {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The command string.
 */
private final String commandString = null;

/**
 * The command arguments.
 */
private final String[] args = null;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Gets the command string.
 *
 * @return The command string.
 */
public String getCommandString() {
    return (commandString);
}

/**
 * Gets the command arguments.
 *
 * @return The command arguments.
 */
public String[] getArgs() {
    // @To-do: Return a shallow copy.
    return (args);
}

public String getArg(int index) {
    return (args[index]);
}

}
