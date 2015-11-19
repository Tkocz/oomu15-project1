package grupp0.arena.server.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.controller.Connection;
import grupp0.arena.base.controller.command.NetworkCommand;
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
 * PUBLIC METHODS
 *----------------------------------------------*/

/*------------------------------------------------
 * PROTECTED METHODS
 *----------------------------------------------*/

@Override
protected NetworkCommand createCommand(String commandString) {
    NetworkCommand command = null;

    switch(commandString){

    case "login": command = new LoginCommand(); break;

    }

    return (command);
}

}
