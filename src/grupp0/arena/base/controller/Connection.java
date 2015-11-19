package grupp0.arena.base.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.Arena;
import grupp0.arena.base.controller.command.NetworkCommand;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
 * Represents a connection able to parse text commands.
 *
 * @author Philip Arvidsson (S133686)
 */
public abstract class Connection implements Runnable {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The connection socket.
 */
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
    try (InputStreamReader isr = new InputStreamReader(socket.getInputStream());
         BufferedReader    br  = new BufferedReader   (isr))
    {
        while(!socket.isClosed()) {
            String         s       = br.readLine();
            NetworkCommand command = parseCommand(s);

            if (command == null) {
                Arena.trace("Unknown command: " + s);
                continue;
            }

            command.setConnection(this);

            Arena.trace("Received command: " + s);

            try {
                command.perform();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    catch (Exception ex) {
        //ex.printStackTrace();

        // Probably just disconnected here?
        Arena.trace("Connection closed: " + socket.toString());
    }
}

public void sendCommand(NetworkCommand command){
    try {
        PrintWriter output = new PrintWriter(socket.getOutputStream());
        output.println(command.toString());
        output.flush();
        Arena.trace("Command sent: " + command.toString());
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

/*------------------------------------------------
 * PROTECTED METHODS
 *----------------------------------------------*/

protected abstract NetworkCommand createCommand(String commandString);

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
private NetworkCommand parseCommand(String s) {
    Scanner scanner = new Scanner(s);
    ArrayList<String> arrListCommand = new ArrayList<>();
    String temp;


    while(scanner.hasNext()){
        temp = scanner.next();
        if (temp.charAt(0) == '"') {
            temp = temp.substring(1, temp.length());
            if (temp.charAt(temp.length() - 1) == '\"') {
                temp = temp.substring(0, temp.length() - 1);
            }else {
                while (scanner.hasNext()) {
                    temp = temp.concat(" ");
                    temp = temp.concat(scanner.next());
                    if (temp.charAt(temp.length() - 1) == '\"') {
                        temp = temp.substring(0, temp.length() - 1);
                        break;
                    }
                }
            }
        }
        arrListCommand.add(temp);
    }

    String[] args = arrListCommand.toArray(new String[0]);

    NetworkCommand cmd = createCommand(args[0]);

    if (cmd == null)
        return (null);

    String[] arrayCopy = Arrays.copyOfRange(args, 1, args.length);
    cmd.setArgsWithoutQuotes(arrayCopy);

    return(cmd);
}

}
