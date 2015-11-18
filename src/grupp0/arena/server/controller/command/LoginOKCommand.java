package grupp0.arena.server.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

 /*------------------------------------------------
  * CLASS
  *----------------------------------------------*/

/**
 * Represents a login response command.
 *
 * @author Philip Arvidsson (S133686)
 */
public class LoginOKCommand extends ServerNetworkCommand {

public LoginOKCommand(String username, String userType) {
    setArgs(new String[] { username, userType });
}

@Override
public String getCommandString() {
    return ("login_ok");
}

}
