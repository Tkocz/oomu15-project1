package grupp0.arena.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.controller.DatabaseManager;
import grupp0.arena.model.User;
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

private DatabaseManager database = new DatabaseManager();

private User loggedInUser;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public DatabaseManager getDatabase() {
    return (database);
}

/**
 * Gets the client instance.
 *
 * @return The client instance.
 */
public static Client getInstance() {
    return (instance);
}

/**
 * Gets the logged in user.
 *
 * @return The currently logged in user, or null if the user has not logged in
 *         yet.
 */
public User getLoggedInUser() {
    return (loggedInUser);
}

/**
 * Sets the logged in user.
 *
 * @param value The user that logged in, or null if a logged in user logged out.
 */
public void setLoggedInUser(User value) {
    loggedInUser = value;
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
