package grupp0.arena.view;

import grupp0.arena.controller.Client;
import grupp0.arena.model.GameInfo;
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

public class LobbyWindow extends AppWindow{

 /**
 * Pane for displaying Icons
 */
@FXML
private FlowPane gameIcons;

 /**
 * Button for exiting the application
 */
@FXML
private Button quitButton;
 /**
 * Textfield for info about selected game
 */
@FXML
private Label gameInfo;

 /**
 * Textfield for info about selected game
 */
@FXML
private Label gameTournament;

    public LobbyWindow(){

        FXMLLoader fxml= new FXMLLoader(getClass().getResource("/fxml/LobbyWindow.fxml"));

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
         for (GameInfo gi : Client.getInstance().getDatabase().getGames())
            gameIcons.getChildren().add(new GameIcon (gi));
    }

    private void setupHandlers() {
    quitButton.setOnAction(e -> close());
    }
}
