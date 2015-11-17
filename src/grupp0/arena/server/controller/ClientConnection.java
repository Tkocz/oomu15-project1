package grupp0.arena.client.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.server.controller.command.ServerNetworkCommand;

import java.net.Socket;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a server-side connection to a client.
 *
 * @author Philip Arvidsson (S133686)
 */
public class ClientConnection implements Runnable {

private Socket socket;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public Socket getSocket() {
    return (socket);
}

public void setSocket(Socket value) {
    socket = value;
}

public void send(ServerNetworkCommand command) {
    // Skicka iväg kommandohelvetet här.
}

@Override
public void run() {
    // Här ska det hända grejer!
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
