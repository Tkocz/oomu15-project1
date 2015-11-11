package grupp0.arena.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.view.LobbyWindow;
import grupp0.arena.view.LoginWindow;
import grupp0.arena.view.SplashWindow;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Main program class.
 *
 * @author Philip Arvidsson (S133686)
 */
public class Client {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The client instance.
 */
private static final Client instance = new Client();

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Gets the client instance.
 *
 * @return The client instance.
 */
public static Client getInstance() {
    return (instance);
}

/**
 * Runs the client.
 *
 * @param args The program arguments.
 */
public void run(String[] args) {
    new SplashWindow().showAndWait();
    new LoginWindow ().showAndWait();
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Private constructor.
 */
private Client() {
    /* ... */
}

}
