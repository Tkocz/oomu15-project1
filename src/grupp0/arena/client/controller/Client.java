package grupp0.arena.client.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.Arena;
import grupp0.arena.base.model.GameInfo;
import grupp0.arena.base.model.User;
import grupp0.arena.client.controller.command.ClientNetworkCommand;
import grupp0.arena.client.view.LobbyWindow;
import grupp0.arena.client.view.LoginWindow;
import grupp0.arena.client.view.SplashWindow;
import grupp0.arena.client.controller.ClientToServerConnection;

import java.util.List;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Main program class.
 *
 * @author Philip Arvidsson (S133686)
 */
public class Client {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The client instance.
 */
private static final Client instance = new Client();

private ClientToServerConnection connection;

private final SimpleStringProperty chatTextProperty = new SimpleStringProperty();

private final SimpleListProperty gamesProperty = new SimpleListProperty<GameInfo>(FXCollections.observableArrayList(new ArrayList<GameInfo>()));

private final SimpleObjectProperty adProperty = new SimpleObjectProperty();

/**
 * The logged in user.
 */
private User loggedInUser;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public SimpleStringProperty chatTextProperty() {
    return chatTextProperty;
}

public SimpleListProperty<GameInfo> gamesProperty(){
    return gamesProperty;
}

public SimpleObjectProperty adProperty(){
    return adProperty;
}

public ClientToServerConnection getConnection() {
    return (connection);
}
/**
 * Gets the client instance.
 *
 * @return The client instance.
 */
public static Client getInstance() {
    return (instance);
}

/**
 * Gets the logged in user.
 *
 * @return The currently logged in user, or null if the user has not logged in
 *         yet.
 */
public User getLoggedInUser() {
    return (loggedInUser);
}

/**
 * Sets the logged in user.
 *
 * @param value The user that logged in, or null if a logged in user logged out.
 */
public void setLoggedInUser(User value) {
    loggedInUser = value;
}

/**
 * Runs the client.
 *
 * @param args The program arguments.
 */
public void run(String[] args) {
    Arena.setClientThread();

    Arena.trace("Connecting...");
    // @Todo: Address should not be hard-coded.
    Socket socket = null;
    try {
        socket = new Socket("localhost", 8000);
        Arena.trace("Connected!");
    }
    catch (Exception ex) {
        ex.printStackTrace();
        Arena.trace("Connection failed.");
    }

    connection = new ClientToServerConnection();
    connection.setSocket(socket);
    Arena.fork(connection);

    new SplashWindow().showAndWait();
    new LoginWindow ().showAndWait();
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/

/**
 * Private constructor.
 */
private Client() {
    /* ... */
}

}
