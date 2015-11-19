package grupp0.arena.server.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.model.GameInfo;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a game list command.
 *
 * @author Philip Arvidsson (S133686)
 */
public class GameListCommand extends ServerNetworkCommand {

public GameListCommand(GameInfo[] games) {
    String[] args = new String[3*games.length+1];

    args[0] = Integer.toString(games.length);

    for (int i = 0; i < games.length; i++) {
        args[i*3+1] = games[i].getName();
        args[i*3+2] = games[i].getDescription();
        args[i*3+3] = games[i].getImageURL();
    }

    setArgs(args);
}

@Override
public String getCommandString() {
    return ("game_list");
}

}
