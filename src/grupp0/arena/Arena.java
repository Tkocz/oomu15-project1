package grupp0.arena;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.client.controller.Client;
import grupp0.arena.server.controller.Server;

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
 * FIELDS
 *----------------------------------------------*/

/**
 * This is used to determine whether the current thread is a client thread or
 * not.
 */
private static final ThreadLocal<Boolean> isClientThread =
    new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return (false);
        }
    };

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Simple utility method to make threading neater.
 *
 * @param runnable The runnable to fork.
 *
 * @return The spawned thread.
 */
public static Thread fork(Runnable runnable) {
    boolean clientThread = isClientThread.get();

    Thread thread = new Thread(() -> {
        if (clientThread) setClientThread();
        else              setServerThread();

        runnable.run();
    });
    thread.start();

    return (thread);
}

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

    new Thread(() -> {
        Server.getInstance().run(getParameters().getRaw().toArray(new String[0]));
    }).start();

    try {
        Thread.sleep(1000);
    }
    catch (InterruptedException ex) { /* ... */ }

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

/**
 * Marks the current thread as a client thread.
 */
public static void setClientThread() {
    isClientThread.set(true);
}

/**
 * Marks the current thread as a server thread.
 */
public static void setServerThread() {
    isClientThread.set(false);
}

/**
 * Traces the specified string.
 *
 * @param format String format.
 * @param args   String format arguments.
 */
public static void trace(String format, Object... args) {
    boolean flag = isClientThread.get();
    String  str  = (flag ? "[client] "
                         : "[server] ")
                 + String.format(format, args);

    System.out.println(str);
}

}
