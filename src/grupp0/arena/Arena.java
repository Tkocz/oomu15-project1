/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena;

import grupp0.arena.controller.Client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Arena extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.close();
        primaryStage = null;

        new Client().run(getParameters().getRaw().toArray(new String[0]));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
