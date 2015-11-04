package grupp0.arena.controller;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Client {
    public void run(String[] args) {
        System.out.println("HEYLOOOOO");

        Stage stage = new Stage();
        Scene scene = new Scene(new Button("ASS was here!!!!11"));
        stage.setScene(scene);
        stage.showAndWait();
    }
}
