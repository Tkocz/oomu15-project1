package grupp0.arena.client.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/


/**
 * This is the client's view of the application
 * 
 * @author Martin Bergqvist (S141564)
 */
public class MessageBox extends AppWindow{
    
    /**
    * Button for accepting the message
    */
   @FXML
    private Button okButton;
   
   /**
    * Label for the message
    */
   @FXML
    private Label messageLabel;
   
    public MessageBox(String message, String title, String details) {

        FXMLLoader fxml= new FXMLLoader(getClass().getResource("/fxml/MessageBox.fxml"));

        fxml.setController(this);

        try {
            setScene(new Scene(fxml.load())); 
            setResizable(false);
            setTitle(title);
            getIcons().add(new Image("images/icon.png"));
            messageLabel.setText(message);
            setupHandlers();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show(String message, String title, String details) {
        new MessageBox(message, title, details).showAndWait();
    }
    
    private void setupHandlers() {
        okButton.setOnAction((e) -> close());    
    }
}