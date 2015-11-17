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
public class LoginOKCommand extends ServerNetworkCommand{

@Override
public String getCommandString() {
    return ("login_ok");
}

@Override
public void perform() {
}

}
