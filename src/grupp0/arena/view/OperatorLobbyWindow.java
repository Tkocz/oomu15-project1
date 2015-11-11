package grupp0.arena.view;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class OperatorLobbyWindow extends AppWindow{

 /**
 * Pane for displaying stuff?
 */
@FXML
private FlowPane operatorIcons;

 /**
 * Button for exiting the application
 */
@FXML
private Button quitButton;

    public OperatorLobbyWindow(){

        FXMLLoader fxml= new FXMLLoader(getClass().getResource("/fxml/OperatorLobbyWindow.fxml"));

        fxml.setController(this);

        try {
            setScene(new Scene(fxml.load()));
            setResizable(false);
            setTitle("asyar14h/oomu/Projekt - grupp 0");
            getIcons().add(new Image("images/icon.png"));
            setupHandlers();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupHandlers() {
    quitButton.setOnAction(e -> close());
    }
}
