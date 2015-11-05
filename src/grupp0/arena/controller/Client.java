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
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Runs the client.
 *
 * @param args The program arguments.
 */
public void run(String[] args) {
    new SplashWindow().showAndWait();
    new LoginWindow().showAndWait();
}

}
