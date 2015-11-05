package grupp0.arena.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginWindow extends Stage{
    public LoginWindow(){
        
        setResizable(false);
        setTitle("Login A.R.E.N.A");
        getIcons().add(new Image("images/icon.png"));
            
        BorderPane pane = new BorderPane();
        HBox hboxUser = new HBox();
        HBox hboxPass = new HBox();
        VBox inputFields = new VBox();
        
        Text userName = new Text("Username:");
        TextField inputUser = new TextField();
        
        Text password = new Text("Password:");
        TextField inputPass = new TextField();
        
        hboxUser.getChildren().addAll(userName, inputUser);
        hboxPass.getChildren().addAll(password,inputPass);
        inputFields.getChildren().addAll(hboxUser,hboxPass);
        
        hboxUser.setAlignment(Pos.CENTER);
        hboxUser.setSpacing(20);
        hboxPass.setAlignment(Pos.CENTER);
        hboxPass.setSpacing(20);
        
        inputFields.setAlignment(Pos.CENTER);
        inputFields.setSpacing(8);
        
        Button ok = new Button("Login");
        ok.setOnAction(e -> {  this.close(); 
                                    new LobbyWindow ().showAndWait();
                                });
        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> {  System.exit(1);
                                });
        HBox btns = new HBox();
        btns.getChildren().addAll(ok,cancel);
        btns.setAlignment(Pos.BASELINE_RIGHT);
        btns.setSpacing(10);
        btns.setPadding(new Insets(2,10,15,2));
 
        
        inputFields.getChildren().add(btns);
        
        pane.setCenter(inputFields);
        pane.setBottom(btns);

        
        
        Scene scene = new Scene(pane, 400, 175);
        setScene(scene);
        
    }
}
