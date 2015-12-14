package grupp0.arena.client.view;

import grupp0.arena.Arena;
import grupp0.arena.base.model.GameInfo;
import grupp0.arena.client.controller.Client;
import java.io.File;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;


/**
 * This is the client's view of the application
 * 
 * @author Martin Bergqvist (S141564)
 */
public class OperatorLobbyWindow extends AppWindow{

 
 /**
 * Displays the Active User
 */
@FXML
private Label activeUser;   

 /**
 * Pane for displaying Icons
 */
@FXML
private FlowPane listedObjects;

/**
 * Button for adding an Advertisement
 */
@FXML
private Button addOpButton;

/**
 * Button for adding funds
 */
@FXML
private Button op2Button;

/**
 * Button for adding a scheme
 */
@FXML
private Button op3Button;

/**
 * Button for exiting the application
 */
@FXML
private Button quitButton;

/**
 * Textfield for info about selected game
 */
@FXML
private Label objectDescription;

private GameInfo selectedGame = null;

    public OperatorLobbyWindow(){

        FXMLLoader fxml= new FXMLLoader(getClass().getResource("/fxml/OperatorLobbyWindow.fxml"));

        fxml.setController(this);

        try {
            setScene(new Scene(fxml.load()));
            setResizable(false);
            setTitle("asyar14h/oomu/Projekt - grupp 0 Operator Lobby");
            getIcons().add(new Image("images/icon.png"));
            setupHandlers();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupHandlers() {
        quitButton.setOnAction(e -> close());
        addOpButton.setOnAction(e -> close());
        op3Button.setOnAction(e -> close());
                
        Client.getInstance().gamesProperty().addListener(new ListChangeListener() {
            public void onChanged(ListChangeListener.Change o) {
                Platform.runLater(() -> {
                    updateGames();
                });
            }
        });
        
        updateGames();

        op2Button.setOnAction((e) -> {
            if (selectedGame == null)
                return;

            String path = "./resources/games/" + selectedGame.getName() + "Server.jar";

            File f = new File(path);
            if (!f.exists()) {
                Arena.trace("Service not available at this time...");
            }

            Arena.trace("shit is running");

            //ProcessBuilder pb = new ProcessBuilder("/path/to/java", "-jar", path);
            //pb.directory(new File("./"));
            //Process p = pb.start();
            Runtime r = Runtime.getRuntime();
            try {
                Process p = r.exec("java -jar " + path);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    void updateGames() {
         for (GameInfo gi : Client.getInstance().gamesProperty().getValue()) {
            GameIcon gameIcon = new GameIcon (gi);
            gameIcon.setOnMouseClicked(e -> {
                selectedGame = gi;
                Platform.runLater(() -> objectDescription.setText(gi.getDescription()));
            });
            listedObjects.getChildren().add(gameIcon);
            listedObjects.getChildren().add(new Separator());
         }
    }
}