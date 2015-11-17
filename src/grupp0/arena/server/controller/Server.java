package grupp0.arena.server.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.model.User;
import grupp0.arena.server.controller.DatabaseManager;

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
    while (true) {
        System.out.println("kan nagon implementera mig? SNALLAAAAA");
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException ex) { }
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
