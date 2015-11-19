/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.server.controller.command;

import grupp0.arena.server.controller.Server;
import grupp0.arena.server.controller.ServerToClientConnection;

/**
 *
 * @author Rasmus
 */
public class ChatCommand extends ServerNetworkCommand{
    public ChatCommand(){

    }

    public ChatCommand(String name, String text){
        setArgs(new String[]{name, text});
    }

    @Override
    public String getCommandString(){
        return "chat";
    }

    @Override
    public void perform(){
        String user = ((ServerToClientConnection)getConnection()).getUser().getName();
        String text = getArg(1);
        Server.getInstance().broadcastCommand(new ChatCommand(user, text));
    }
}
