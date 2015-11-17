package grupp0.arena.base.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

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

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Gets the command string.
 *
 * @return The command string.
 */
public String getCommandString() {
    return (null);
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

public abstract void perform();

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
