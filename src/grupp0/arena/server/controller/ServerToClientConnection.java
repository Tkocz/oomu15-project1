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

private User user;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public User getUser() {
    return (user);
}

public void setUser(User value) {
    user = value;
}

@Override
public void run() {
    super.run();
    // @Todo: Ta bort anslutningen från server connectiosn här
}

/*------------------------------------------------
 * PROTECTED METHODS
 *----------------------------------------------*/

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
