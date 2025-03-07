package grupp0.arena.base.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.Arena;

import grupp0.arena.base.model.Advertiser;
import grupp0.arena.base.model.Operator;
import grupp0.arena.base.model.Player;
import grupp0.arena.base.model.User;
import grupp0.arena.base.model.UserType;

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
 *
 * @return A user of the specified type, or null if an object couldn't be
 *         created.
 */
public User createUser(UserType type) {
    switch (type) {

    case OPERATOR: return new Operator();
    case PLAYER  : return new Player  ();
    case ADVERTISER: return new Advertiser();

    }

    Arena.trace("Unknown user type: " + type.toString());
    return (null);
}

}
