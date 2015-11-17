/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package grupp0.arena.server.controller.command;

import grupp0.arena.base.model.User;
import grupp0.arena.server.controller.Server;

/**
*
* @author Rasmus
*/
public class LoginCommand extends ServerNetworkCommand{

public LoginCommand(){
}

@Override
public void perform() {
    String username = getArg(0);
    String password = getArg(1);
    
    User user = Server.getInstance().getDatabase().loginUser(username, password);
    
    if(user == null)
        sendCommand(new LoginFailCommand());
    else
        sendCommand(new LoginOKCommand());
        
}

}
