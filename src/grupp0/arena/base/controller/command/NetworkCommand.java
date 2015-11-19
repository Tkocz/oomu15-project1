package grupp0.arena.base.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.controller.Connection;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a command.
 *
 * @author Philip Arvidsson (S133686)
 */
public abstract class NetworkCommand {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The command arguments.
 */
private String[] args;

/**
 * The relevant connection.
 */
private Connection connection;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Gets the command arguments.
 *
 * @return The command arguments.
 */
public String[] getArgs() {
    // @To-do: Return a shallow copy.
    return (args);
}

/**
 * Gets the command string.
 *
 * @return The command string.
 */
public String getCommandString() {
    throw new UnsupportedOperationException("Not implemented!");
}

public Connection getConnection() {
    return (connection);
}

public void setConnection(Connection value) {
    connection = value;
}

/**
 * getArg accessor method
 * @param index is the parameter for the argument whished to be returned
 * @return returns a string which is the argument decided by the index entered
 */
public String getArg(int index) {
    return (args[index]);
}

/**
 * setArgs accessor method
 * @param args takes an array which hold the argument that is suposed to be handled.
 */
public void setArgs(String[] args){
    this.args = args;
}

public void perform() {
    throw new UnsupportedOperationException("Not implemented!");
}

@Override
public String toString() {
    String s = getCommandString();

    if (args == null)
        return (s);

    for (String arg : args)
        s += " " + arg;

    return (s);
}

}
