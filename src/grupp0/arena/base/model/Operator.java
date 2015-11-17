package grupp0.arena.base.model;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.model.UserType;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents an operator.
 *
 * @author Philip Arvidsson (S133686)
 */
public class Operator extends User {

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

@Override
public UserType getType() {
    return (UserType.OPERATOR);
}

}
