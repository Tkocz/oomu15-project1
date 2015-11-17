/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package grupp0.arena.server.controller.command;

/**
*
* @author Rasmus
*/
public class LoginCommand extends ServerNetworkCommand{

private String status;

public LoginCommand(String status){
    this.status = status;
}

@Override
public void perform() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

}
