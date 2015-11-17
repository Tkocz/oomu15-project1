package grupp0.arena.base.model;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.base.model.UserType;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a single user.
 *
 * @author Philip Arvidsson (S133686)
 */
public abstract class User {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The username.
 */
private String name;

/**
 * The password.
 */
private String password;

/**
 * The user's real name.
 */
private String realName;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Gets the username.
 *
 * @return The username.
 */
public String getName() {
    return (name);
}

/**
 * Sets the username.
 *
 * @param value The username.
 */
public void setName(String value) {
    name = value;
}

/**
 * Gets the password.
 *
 * @return The password.
 */
public String getPassword() {
    return (password);
}

/**
 * Sets the password.
 *
 * @param value The password.
 */
public void setPassword(String value) {
    password = value;
}

/**
 * Gets the user's real name.
 *
 * @return The user's real name.
 */
public String getRealName() {
    return (realName);
}

/**
 * Sets the user's real name.
 *
 * @param value The user's real name.
 */
public void setRealName(String value) {
    realName = value;
}

/**
 * Gets the user type.
 *
 * @return The user type.
 */
public abstract UserType getType();

}
