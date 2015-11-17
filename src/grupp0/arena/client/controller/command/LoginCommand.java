package grupp0.arena.client.controller.command;

/**
 *
 * @author Rasmus
 */
public class LoginCommand extends ClientNetworkCommand {

public LoginCommand(String username, String password) {
    setArgs(new String[] { username, password });
}

@Override
public String getCommandString() {
    return ("login");
}

public String getUsername() {
    return (getArg(0));
}

public String getPassword() {
    return (getArg(1));
}

}
