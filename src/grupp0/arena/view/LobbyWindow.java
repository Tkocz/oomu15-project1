package grupp0.arena.view;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class LobbyWindow extends Stage{

    public LobbyWindow(){
        //String     className = getClass().getSimpleName();
        //String     viewName  = "/fxml/" +className + ".fxml";

        FXMLLoader fxml      = new FXMLLoader(getClass().getResource("/fxml/LobbyWindow.fxml"));

        fxml.setController(this);

        try {
            setScene(new Scene(fxml.load()));
            setResizable(false);
            setTitle("asyar14h/oomu/Projekt - grupp 0");
            getIcons().add(new Image("images/icon.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
