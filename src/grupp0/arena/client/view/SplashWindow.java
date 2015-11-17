package grupp0.arena.client.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Provides a splash window. ;-)
 *
 * @author Philip Arvidsson (S133686)
 */
public class SplashWindow extends AppWindow {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 */
public SplashWindow() {
    Image     splashImage = new Image    ("/images/splash.png");
    ImageView imageView   = new ImageView(splashImage         );
    Group     root        = new Group    (imageView           );
    Scene     scene       = new Scene    (root                );

    // Remove window decorations and show the splash screen image! :-)
    initStyle(StageStyle.UNDECORATED);
    setScene (scene);
}

/**
 * Displays the splash window for two seconds.
 */
@Override
public void showAndWait() {
    setTimeout(() -> close(), 2000);
    super.showAndWait();
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Sets a callback to be executed in the specified amount of time.
 *
 * @param runnable       The runnable to run after the timeout.
 * @param delayMillisecs The delay, in milliseconds, to wait before executing
 *                       the runnable.
 */
private void setTimeout(Runnable runnable, int delayMillisecs) {
    new Thread(() -> {
        try {
            Thread.sleep(delayMillisecs);
        }
        catch (InterruptedException ex) { /* ... */ }

        Platform.runLater(() -> runnable.run());
    }).start();
}

}
