package grupp0.arena.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.model.Player;
import grupp0.arena.model.User;
import grupp0.arena.model.UserType;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Factory class for instantiating users.
 *
 * @author Philip Arvidsson (S133686)
 */
public class UserFactory {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Runs the client.
 *
 * @param args The program arguments.
 */
public User createUser(UserType type) {
    switch (type) {

    case PLAYER: return new Player();

    }

    // @To-do: Log this. Specified type is unknown.
    return (null);
}

}
