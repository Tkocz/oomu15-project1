package grupp0.arena.server.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.server.controller.command.LoginCommand;
import grupp0.arena.server.controller.command.ServerNetworkCommand;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Compiler.command;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a server-side connection to a client.
 *
 * @author Philip Arvidsson (S133686)
 */
public class ClientConnection implements Runnable {

private Socket socket;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public Socket getSocket() {
    return (socket);
}

public void setSocket(Socket value) {
    socket = value;
}

public void send(ServerNetworkCommand command) {
    // Skicka iväg kommandohelvetet här.
}

@Override
public void run() {
    while(!socket.isClosed()){
        String input;
        try {
            input = socket.getInputStream().toString();
            ServerNetworkCommand command = interpret(input);
            command.perform();
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public void sendCommand(ServerNetworkCommand command){
    command.toString();
    socket.
}

/*------------------------------------------------
 * PRIVATE METHODS
 *----------------------------------------------*/


/**
 * interpret method is used to enable the client to access the server
 * by communicating by commands
 * @param s parameter which is a string and should contain an command and one or 
 * multiple arguments
 * @return returns a object of a ServerNetworkCommand type
 */
    public ServerNetworkCommand interpret(String s) {
        // Kan någon vara vänlig att implementera mig? Tack på förhand.
        Scanner scanner = new Scanner(s);
        ArrayList<String> arrListCommand = new ArrayList<>();

        while(scanner.hasNext()){
            arrListCommand.add(scanner.next());
        }

        String[] args = new String[arrListCommand.size()];

        args = (String[]) arrListCommand.toArray();

        ServerNetworkCommand cmd = createCommand(args[0]);
        String[] arrayCopy = Arrays.copyOfRange(args, 1, args.length);
        cmd.setArgs(arrayCopy);

        return(cmd);
    }
    
    private ServerNetworkCommand createCommand(String arg) {
    //Denna metoden ska ta emot argumenten och så ska vi göra någonting roligt med dem :)
    
        switch(arg){
            case "login":
            {
                LoginCommand lgc = new LoginCommand();
                return(lgc);
            }

        }
    
        return null;
    }
}
