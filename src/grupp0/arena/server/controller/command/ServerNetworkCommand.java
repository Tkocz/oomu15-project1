package grupp0.arena.server.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.controller.command.NetworkCommand;
import grupp0.arena.server.controller.ClientConnection;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a server network command.
 *
 * @author Philip Arvidsson (S133686)
 */
public abstract class ServerNetworkCommand extends NetworkCommand {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The relevant connection.
 */
private ClientConnection connection;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public ClientConnection getConnection() {
    return (connection);
}

public void setConnection(ClientConnection value) {
    connection = value;
}

}
