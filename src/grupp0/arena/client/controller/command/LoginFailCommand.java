package grupp0.arena.client.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.client.controller.command.ClientNetworkCommand;
import grupp0.arena.client.view.MessageBox;

import javafx.application.Platform;

 /*------------------------------------------------
  * CLASS
  *----------------------------------------------*/

/**
 * Represents a login response command.
 *
 * @author Philip Arvidsson (S133686)
 */
public class LoginFailCommand extends ClientNetworkCommand {

 /*------------------------------------------------
  * PUBLIC METHODS
  *----------------------------------------------*/

@Override
public void perform() {
    Platform.runLater(() -> MessageBox.show("Login failed!", "Login Fail", null));
}

}
