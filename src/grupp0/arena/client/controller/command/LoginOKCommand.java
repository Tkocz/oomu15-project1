package grupp0.arena.client.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.Arena;
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

    Class c = null;
         if (userType.equals("PLAYER"    )) c = LobbyWindow.class;
    else if (userType.equals("OPERATOR"  )) c = OperatorLobbyWindow.class;
    else if (userType.equals("ADVERTISER")) c = AdvertiserLobbyWindow.class;
    else Arena.trace("Unknown user type: " + userType);

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
