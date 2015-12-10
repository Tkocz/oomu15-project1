package grupp0.arena.client.view;

import grupp0.arena.Arena;
import grupp0.arena.base.model.AdvertisementInfo;
import grupp0.arena.base.model.GameInfo;
import grupp0.arena.client.controller.Client;
import grupp0.arena.server.controller.Server;
import grupp0.arena.server.controller.command.ChatCommand;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import java.util.Hashtable;
import java.io.File;


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

@FXML
private Button singlePlayerButton;

@FXML
private Button quickMatchButton;

@FXML
private ImageView adImageView;

/**
 * Textfield for info about selected game
 */
@FXML
private Label gameDescription;

private GameInfo selectedGame = null;

private Hashtable<String, Image> adCache = new Hashtable<>();

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
            //lobbyChatView.appendText("\n" + lobbyChatField.getText());
            // @Todo: Skicka iväg ett new ChatCommand här!
            Client.getInstance().getConnection().sendCommand(new ChatCommand("", lobbyChatField.getText()));
            lobbyChatField.clear();
        });
        //activeUser.setText("Logged in as: " +Client.getInstance().getLoggedInUser().getName());
        //sendChatButton.setOnAction(e -> lobbyChatView.appendText("\n" +lobbyChatField.getText()));
        //activeUser.setText("Logged in as: " +Client.getInstance().getLoggedInUser().getName());
        Client.getInstance().adProperty().addListener((o) -> {
            AdvertisementInfo ad = ((AdvertisementInfo)((SimpleObjectProperty)o).getValue());

            if (ad == null)
                return;

            Platform.runLater(() -> {
                //Arena.trace("nu ska vi visa en ad");
                //adImageView.setImage(new Image(ad.getImageURL()));
                if (!adCache.contains(ad.getImageURL()))
                    adCache.put(ad.getImageURL(), new Image(ad.getImageURL()));

                adImageView.setImage(adCache.get(ad.getImageURL()));

            });
        });

        Client.getInstance().gamesProperty().addListener(new ListChangeListener() {
            public void onChanged(ListChangeListener.Change o) {
                Platform.runLater(() -> {
                    updateGames();
                });
            }
        });

        lobbyChatView.textProperty().bind(Client.getInstance().chatTextProperty());
        updateGames();

        singlePlayerButton.setOnAction((e) -> {
            if (selectedGame == null)
                return;

            String path = "games/" + selectedGame.getName() + ".jar";

            File f = new File(path);
            if (!f.exists()) {
                installGame(gi);
            }

            Arena.trace("shit is installed");

            //ProcessBuilder pb = new ProcessBuilder("/path/to/java", "-jar", path);
            //pb.directory(new File("./"));
            //Process p = pb.start();
            Runtime.exec("java -jar " + path);
        });
    }

    void installGame(GameInfo gi) {

    }

    void updateGames() {
         for (GameInfo gi : Client.getInstance().gamesProperty().getValue()) {
            GameIcon gameIcon = new GameIcon (gi);
            gameIcon.setOnMouseClicked(e -> {
                selectedGame = gi;
                Platform.runLater(() -> gameDescription.setText(gi.getDescription()));
            });
            gameIcons.getChildren().add(gameIcon);
            gameIcons.getChildren().add(new Separator());
         }
    }
}
