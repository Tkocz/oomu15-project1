package grupp0.arena.client.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.controller.Connection;
import grupp0.arena.base.controller.command.NetworkCommand;
import grupp0.arena.client.controller.command.GameListCommand;
import grupp0.arena.client.controller.command.LoginFailCommand;
import grupp0.arena.client.controller.command.LoginOKCommand;

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

    case "game_list" : command = new GameListCommand (); break;
    case "login_fail": command = new LoginFailCommand(); break;
    case "login_ok"  : command = new LoginOKCommand  (); break;

    }

    return (command);
}

}
