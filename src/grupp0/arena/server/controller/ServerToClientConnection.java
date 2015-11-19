package grupp0.arena.server.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.controller.Connection;
import grupp0.arena.base.controller.command.NetworkCommand;
import grupp0.arena.base.model.User;

import grupp0.arena.server.controller.command.ChatCommand;
import grupp0.arena.server.controller.command.LoginCommand;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a server-side connection to a client.
 *
 * @author Philip Arvidsson (S133686)
 */
public class ServerToClientConnection extends Connection {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The user associated with the connection.
 */
private User user;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Gets the user associated with the connection.
 *
 * @return The user associated with the connection.
 */
public User getUser() {
    return (user);
}

/**
 * Sets the user associated with the connection.
 *
 * @param value The user to associate with the connection.
 */
public void setUser(User value) {
    user = value;
}

/**
 * Receives commands and performs them until the connection is closed.
 */
@Override
public void run() {
    super.run();

    Server.getInstance().removeConnection(this);
}

/*------------------------------------------------
 * PROTECTED METHODS
 *----------------------------------------------*/

/**
 * Creates a command object for the specified command string.
 *
 * @param commandString The command string to create a command object for.
 *
 * @return A command object.
 */
@Override
protected NetworkCommand createCommand(String commandString) {
    NetworkCommand command = null;

    switch(commandString){

    case "chat" : command = new ChatCommand (); break;
    case "login": command = new LoginCommand(); break;

    }

    return (command);
}

}
