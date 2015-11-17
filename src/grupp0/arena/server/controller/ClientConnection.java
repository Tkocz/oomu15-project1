package grupp0.arena.server.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.server.controller.command.ServerNetworkCommand;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Compiler.command;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    while(!socket.isClosed()){
        String input;
        try {
            input = socket.getInputStream().toString();
            ServerNetworkCommand command = interpret(input);
            command.perform();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

}
