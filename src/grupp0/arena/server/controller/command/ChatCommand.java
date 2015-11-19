/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.server.controller.command;

import grupp0.arena.server.controller.Server;

/**
 *
 * @author Rasmus
 */
public class ChatCommand extends ServerNetworkCommand{
    private String name;
    private String text;
    
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
        Server.getInstance().broadcastCommand(this);
    }
}
