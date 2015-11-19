package grupp0.arena.client.view;

import grupp0.arena.Arena;
import grupp0.arena.base.model.AdvertisementInfo;
import grupp0.arena.client.controller.Client;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;


/**
 * This is the client's view of the application
 *
 * @author Martin Bergqvist (S141564)
 */
public class LobbyWindow extends AppWindow{


 /**
 * Displays the Active User
 */
@FXML
private Label activeUser;
 /**
 * Textarea for displaying the LobbyChat
 */
@FXML
private TextArea lobbyChatView;
 /**
 * Textfield for writing to the LobbyChat
 */
@FXML
private TextField lobbyChatField;

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
 * Button for sending a chat-message to the LobbyChat
 */
@FXML
private Button sendChatButton;
/**
 * Textfield for info about selected game
 */
@FXML
private Label gameDescription;

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
         /*for (GameInfo gi : Client.getInstance().getDatabase().getGames()){
            GameIcon gameIcon = new GameIcon (gi);
             gameIcon.setOnMouseClicked(e -> {
                Platform.runLater(() -> gameDescription.setText(gi.getDescription()));
                        });
            gameIcons.getChildren().add(gameIcon);
            gameIcons.getChildren().add(new Separator());

         }*/
    }

    private void setupHandlers() {
        quitButton.setOnAction(e -> close());
        sendChatButton.setDefaultButton(true);
        sendChatButton.setOnAction(e -> {
            lobbyChatView.appendText("\n" + lobbyChatField.getText());
            lobbyChatField.clear();
        });
        //activeUser.setText("Logged in as: " +Client.getInstance().getLoggedInUser().getName());
        sendChatButton.setOnAction(e -> lobbyChatView.appendText("\n" +lobbyChatField.getText()));
        //activeUser.setText("Logged in as: " +Client.getInstance().getLoggedInUser().getName());
        Client.getInstance().adProperty().addListener((o) -> {
            AdvertisementInfo ad = ((AdvertisementInfo)((SimpleObjectProperty)o).getValue());
            Platform.runLater(() -> {
                Arena.trace("nu ska vi visa en ad");
            });
        });

        /*Client.getInstance().gamesProperty().addListener((ListChangeListener o) -> {
            Platform.runLater(() -> {
                Arena.trace("nu ska vi visa alla games");
            });


        });


        });*/
    }
}
