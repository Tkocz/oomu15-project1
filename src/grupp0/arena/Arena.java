package grupp0.arena;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.controller.Client;

import javafx.application.Application;
import javafx.stage.Stage;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Main class for launching the application.
 *
 * @author Philip Arvidsson (S133686)
 */
public class Arena extends Application {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Starts the application.
 *
 * @param primaryStage Not used.
 */
@Override
public void start(Stage primaryStage) {
    // We don't need this crap stage. lol!
    if (primaryStage != null) {
        primaryStage.close();
        primaryStage = null;
    }

    Client.getInstance().run(getParameters().getRaw().toArray(new String[0]));
}

/**
 * Main method; required for compilation. :-)
 *
 * @param args The program arguments.
 */
public static void main(String[] args) {
    launch(args);
}

}
