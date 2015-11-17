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
public class LoginFailCommand extends ServerNetworkCommand{

@Override
public String getCommandString() {
    return ("login_fail");
}

@Override
public void perform() {
}

}
