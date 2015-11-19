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

@Override
public void perform() {
    int numGames = Integer.parseInt(getArg(0));
    for (int i = 0; i < numGames; i++) {
        String name     = getArg(3*i+1);
        String desc     = getArg(3*i+2);
        String imageURL = getArg(3*i+3);

        GameInfo gi = new GameInfo(name, desc, imageURL);


        Arena.trace("Game: " + gi.getName() + " (" + gi.getDescription() + ")");
        Client.getInstance().gamesProperty().add(gi);
    }

}

}
