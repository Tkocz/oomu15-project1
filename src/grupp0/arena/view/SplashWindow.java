package grupp0.arena.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import java.util.Timer;
import java.util.TimerTask;

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
public class SplashWindow extends Stage {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The timer used to close the splash screen window.
 */
private Timer timer;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public SplashWindow() {
    initStyle(StageStyle.UNDECORATED);

    Image splashImage = new Image("/images/splash.png");

    ImageView imageView = new ImageView();

    imageView.setImage(splashImage);

    setScene(new Scene(new Group(imageView)));

    timer = new Timer("SplashTimer");

    timer.schedule(new TimerTask() {
        public void run() {
            Platform.runLater(() -> close());
        }
    }, 2000);
}

}
