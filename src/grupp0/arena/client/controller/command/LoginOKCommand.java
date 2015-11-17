package grupp0.arena.client.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.Arena;
import grupp0.arena.client.controller.command.ClientNetworkCommand;
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
    String username = getArg(1);
    String userType = getArg(0);

    Class c = null;
         if (userType.equals("player"  )) c = LobbyWindow.class;
    else if (userType.equals("operator")) c = OperatorLobbyWindow.class;
    else Arena.trace("Unknown user type: " + userType);

    // Java wants lambda vars to be effectively final.
    final Class stageClass = c;

    if (stageClass != null)
        Platform.runLater(() -> {
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
