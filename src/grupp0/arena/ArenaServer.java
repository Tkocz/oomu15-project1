package grupp0.arena;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.server.controller.Server;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Main class for launching the server application.
 *
 * @author Philip Arvidsson (S133686)
 */
public class ArenaServer {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Main method; required for compilation. :-)
 *
 * @param args The program arguments.
 */
public static void main(String[] args) {
    Server.getInstance().run(args);
}

}
