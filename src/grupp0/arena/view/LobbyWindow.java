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
    }

    private void setupHandlers() {
    quitButton.setOnAction(e -> close());
    }
    private void setTheText(Button button){
        /*gameInfo.setText(
            "Othello is a strategy board game for two players, played on an 8×8"
                    + " uncheckered board. There are sixty-four identical game"
                    + " pieces called disks (often spelled \"discs\"), which"
                    + " are light on one side and dark on the other. Players"
                    + " take turns placing disks on the board with their"
                    + " assigned color facing up. During a play, any disks of"
                    + " the opponent's color that are in a straight line and"
                    + " bounded by the disk just placed and another disk of the"
                    + " current player's color are turned over to the current"
                    + " player's color.\n The object of the game is to have the"
                    + " majority of disks turned to display your color when the"
                    + " last playable empty square is filled.");*/ //Shit's not working.
    }
}
