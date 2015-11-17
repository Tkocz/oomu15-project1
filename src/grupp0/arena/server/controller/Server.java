package grupp0.arena.server.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.model.User;
import grupp0.arena.server.controller.DatabaseManager;
import grupp0.arena.server.controller.command.ServerNetworkCommand;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Main server program class.
 *
 * @author Philip Arvidsson (S133686)
 */
public class Server {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The server instance.
 */
private static final Server instance = new Server();

// @To-do: Replace this shit with a network interface.
private DatabaseManager database = new DatabaseManager();

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

// @To-do: Replace this shit with a network interface.
public DatabaseManager getDatabase() {
    return (database);
}

/**
 * Gets the server instance.
 *
 * @return The server instance.
 */
public static Server getInstance() {
    return (instance);
}

/**
 * Runs the server.
 *
 * @param args The program arguments.
 */
public void run(String[] args) {
    try {
        ServerSocket server = new ServerSocket(8000);
        while(true){
            Socket socket = server.accept();
            ClientConnection connection = new ClientConnection();
            connection.setSocket(socket);
            Thread t = new Thread(connection);
            t.start();
        }
    } catch (IOException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
    }
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/


/**
 * Private constructor.
 */
private Server() {
    /* ... */
}

}
