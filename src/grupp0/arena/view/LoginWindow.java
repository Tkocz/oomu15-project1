package grupp0.arena.view;

import grupp0.arena.controller.Client;
import grupp0.arena.model.User;
import grupp0.arena.model.UserType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
        PasswordField inputPass = new PasswordField();

        hboxUser.getChildren().addAll(userName, inputUser);
        hboxPass.getChildren().addAll(password,inputPass);
        inputFields.getChildren().addAll(hboxUser,hboxPass);

        hboxUser.setAlignment(Pos.CENTER);
        hboxUser.setSpacing(20);
        hboxPass.setAlignment(Pos.CENTER);
        hboxPass.setSpacing(24);

        inputFields.setAlignment(Pos.CENTER);
        inputFields.setSpacing(8);

        Button ok = new Button("Login");
        ok.setOnAction(e -> {  
           User temp = Client.getInstance().getDatabase().loginUser(inputUser.getText(), inputPass.getText());
       if(temp != null){
           Client.getInstance().setLoggedInUser(Client.getInstance().getDatabase().loginUser(inputUser.getText(), inputPass.getText()));
           this.close();
           if(temp.getType().equals(UserType.PLAYER))
               new LobbyWindow ().showAndWait();
           else if(temp.getType().equals(UserType.OPERATOR))
               new OperatorLobbyWindow().showAndWait();
       }
       else
           MessageBox.show("Fel användarnamn/Lösenord, gör om gör rätt!", "Inloggning Misslyckad!");
        });
        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> {  System.exit(1);
                                });
        HBox btns = new HBox();
        btns.getChildren().addAll(ok,cancel);
        btns.setAlignment(Pos.BASELINE_RIGHT);
        btns.setSpacing(10);
        btns.setPadding(new Insets(2,10,15,2));
        ok.setDefaultButton(true);


        inputFields.getChildren().add(btns);

        pane.setCenter(inputFields);
        pane.setBottom(btns);



        Scene scene = new Scene(pane, 340, 145);
        scene.getStylesheets().add(LoginWindow.class.getResource("/stylesheets/darktheme.css").toExternalForm());
        setScene(scene);

    }
}
