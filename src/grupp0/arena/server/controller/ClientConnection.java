package grupp0.arena.server.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.server.controller.command.LoginCommand;
import grupp0.arena.server.controller.command.ServerNetworkCommand;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.Compiler.command;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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

@Override
public void run() {
    while(!socket.isClosed()){
        String input;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            input = in.readLine();
            ServerNetworkCommand command = interpret(input);
            if (command != null) {
                command.setConnection(this);
                command.perform();
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public void sendCommand(ServerNetworkCommand command){
    try {
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.print(command.toString() + "\n");
        pw.flush();
    } catch (IOException ex) {
        Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
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
        System.out.println("interpret " + s);

        Scanner scanner = new Scanner(s);
        ArrayList<String> arrListCommand = new ArrayList<>();

        while(scanner.hasNext()){
            arrListCommand.add(scanner.next());
        }

        String[] args = arrListCommand.toArray(new String[0]);

        ServerNetworkCommand cmd = createCommand(args[0]);

        if (cmd == null)
            return (null);

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

        System.out.print("Unknown command " + arg + "\n");
        return null;
    }
}
