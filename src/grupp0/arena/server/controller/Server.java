package grupp0.arena.server.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.Arena;
import grupp0.arena.base.model.AdvertisementInfo;
import grupp0.arena.base.model.User;
import grupp0.arena.server.controller.DatabaseManager;
import grupp0.arena.server.controller.command.DisplayAdCommand;
import grupp0.arena.server.controller.command.ServerNetworkCommand;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
private final ArrayList<ServerToClientConnection> connections = new ArrayList();

// @Todo: Replace this shit with a network interface.
private DatabaseManager database = new DatabaseManager();

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

// @Todo: Replace this shit with a network interface.
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

public ServerToClientConnection[] getConnections(){
    synchronized(connections){
         return connections.toArray(new ServerToClientConnection[0]);
    }
}

/**
 * Runs the server.
 *
 * @param args The program arguments.
 */
public void run(String[] args) {
    Arena.setServerThread();

    Arena.fork(() -> adThread());

    try {
        ServerSocket server = new ServerSocket(8000);
        Arena.trace("Waiting for connections...");
        while(true){
            Socket socket = server.accept();
            Arena.trace("Connection accepted: " + socket.toString());
            ServerToClientConnection connection = new ServerToClientConnection();
            connection.setSocket(socket);
            synchronized(connections){
                connections.add(connection);
            }
            Arena.fork(connection);
        }
    } catch (IOException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
    }
}
void adThread(){
    Arena.trace("Advertiserment thread running...");
    AdvertisementInfo ads[] = database.getAds();
    Random random = new Random();
    int i = 0;
    while(true){
        AdvertisementInfo ad = ads[(i++) % ads.length];
        broadcastCommand(new DisplayAdCommand(ad.getImageURL(), ad.getLinkURL()));
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

public void broadcastCommand(ServerNetworkCommand command){
    for (ServerToClientConnection connection : getConnections()) {
        // Only broadcast to logged in clients.
        if (connection.getUser() != null)
            connection.sendCommand(command);
    }
}

void removeConnection(ServerToClientConnection conn) {
    synchronized (connections) {
        connections.remove(conn);
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
