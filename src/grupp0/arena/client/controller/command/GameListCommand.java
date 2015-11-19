package grupp0.arena.client.controller.command;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.Arena;
import grupp0.arena.base.model.GameInfo;
import grupp0.arena.client.controller.Client;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a game list command.
 *
 * @author Philip Arvidsson (S133686)
 */
public class GameListCommand extends ClientNetworkCommand {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

@Override
public void perform() {
    Client.getInstance().gamesProperty().clear();

    int numGames = Integer.parseInt(getArg(0));
    for (int i = 0; i < numGames; i++) {
        String   name        = getArg(3*i+1);
        String   description = getArg(3*i+2);
        String   imageURL    = getArg(3*i+3);
        GameInfo gameInfo    = new GameInfo(name, description, imageURL);

        Client.getInstance().gamesProperty().add(gameInfo);
    }

}

}
