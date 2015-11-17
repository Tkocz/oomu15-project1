package grupp0.arena.client.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.controller.Connection;
import grupp0.arena.base.controller.command.NetworkCommand;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a client-side connection to the server.
 *
 * @author Philip Arvidsson (S133686)
 */
public class ClientToServerConnection extends Connection {

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

    }

    if (command != null)
        command.setConnection(this);

    return (command);
}

}
