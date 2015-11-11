package grupp0.arena.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Base class for all windows.
 *
 * @author Philip Arvidsson (S133686)
 */
public class MessageBox extends AppWindow {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor.
 */
public MessageBox(String message, String title) {
    HBox root = new HBox();

    root.getChildren().add(new Text(message));

    Scene scene = new Scene(root);

    setResizable(false);
    setScene(scene);
}

public static void show(String message, String title) {
    new MessageBox(title, message).showAndWait();
}

}
