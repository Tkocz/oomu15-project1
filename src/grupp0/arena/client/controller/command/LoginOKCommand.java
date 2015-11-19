package grupp0.arena.client.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.Arena;

import grupp0.arena.base.controller.UserFactory;
import grupp0.arena.base.model.User;
import grupp0.arena.base.model.UserType;

import grupp0.arena.client.controller.Client;
import grupp0.arena.client.controller.command.ClientNetworkCommand;
import grupp0.arena.client.view.AdvertiserLobbyWindow;
import grupp0.arena.client.view.LobbyWindow;
import grupp0.arena.client.view.OperatorLobbyWindow;

import javafx.application.Platform;
import javafx.stage.Stage;

 /*------------------------------------------------
  * CLASS
  *----------------------------------------------*/

/**
 * Represents a login response command.
 *
 * @author Philip Arvidsson (S133686)
 */
public class LoginOKCommand extends ClientNetworkCommand {

 /*------------------------------------------------
  * PUBLIC METHODS
  *----------------------------------------------*/

@Override
public void perform() {
    String username = getArg(0);
    String userType = getArg(1);
    UserFactory userFactory = new UserFactory();

    Class c    = null;
    User  user = null;
    if (userType.equals("ADVERTISER")) {
        c    = AdvertiserLobbyWindow.class;
        user = userFactory.createUser(UserType.ADVERTISER);
    }
    else if (userType.equals("OPERATOR")) {
        c    = OperatorLobbyWindow.class;
        user = userFactory.createUser(UserType.OPERATOR);
    }
    else if (userType.equals("PLAYER")) {
        c    = LobbyWindow.class;
        user = userFactory.createUser(UserType.PLAYER);
    }
    else {
        Arena.trace("Unknown user type: " + userType);
    }

    Client.getInstance().setLoggedInUser(user);

    // Java wants lambda vars to be effectively final.
    final Class stageClass = c;

    if (stageClass == null)
        return;

    Platform.runLater(() -> {
        // Close ALL windows and go to the lobby or whatever. Super hacky, but
        // it works!
        for (Stage stage : com.sun.javafx.stage.StageHelper.getStages())
            Platform.runLater(() -> stage.close());

        try {
            ((Stage)stageClass.newInstance()).showAndWait();
        }
        catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        catch (InstantiationException ex) {
            ex.printStackTrace();
        }
    });
}

}
